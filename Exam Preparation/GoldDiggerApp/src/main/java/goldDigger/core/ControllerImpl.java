package goldDigger.core;

import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.museum.Museum;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.SpotRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static goldDigger.common.ConstantMessages.*;
import static goldDigger.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private int inspectedSpots = 0;
    private DiscovererRepository discoverers;
    private SpotRepository spots;

    public ControllerImpl() {
        discoverers = new DiscovererRepository();
        spots = new SpotRepository();
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        Discoverer discoverer;
        if (!kind.equals("Anthropologist") && !kind.equals("Archaeologist") && !kind.equals("Geologist")) {
            throw new IllegalArgumentException(DISCOVERER_INVALID_KIND);
        }
        if (kind.equals("Anthropologist")) {
            discoverer = new Anthropologist(discovererName);
        } else if (kind.equals("Archaeologist")) {
            discoverer = new Archaeologist(discovererName);
        } else {
            discoverer = new Geologist(discovererName);
        }
        discoverers.add(discoverer);
        return String.format(DISCOVERER_ADDED, kind, discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot = new SpotImpl(spotName);
        for (String exhibit : exhibits) {
            spot.getExhibits().add(exhibit);
        }

        spots.add(spot);
        return String.format(SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer discoverer = discoverers.byName(discovererName);
        if (discoverer == null) {
            throw new IllegalArgumentException(String.format(DISCOVERER_DOES_NOT_EXIST, discovererName));
        }

        discoverers.remove(discoverer);
        return String.format(DISCOVERER_EXCLUDE, discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {
        List<Discoverer> availableDiscoverers = discoverers.getCollection()
                .stream()
                .filter(d -> d.getEnergy() > 45)
                .collect(Collectors.toList());

        if (availableDiscoverers.isEmpty()) {
            throw new IllegalArgumentException(SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }
        Spot spot = spots.byName(spotName);
        OperationImpl operation = new OperationImpl();
        operation.startOperation(spot, availableDiscoverers);

        long excludedDiscoverers = availableDiscoverers.stream().filter(d -> d.getEnergy() == 0).count();
        inspectedSpots++;
        return String.format(INSPECT_SPOT, spotName, excludedDiscoverers);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(FINAL_SPOT_INSPECT, inspectedSpots)).append(System.lineSeparator());
        sb.append(FINAL_DISCOVERER_INFO);
        for (Discoverer discoverer : discoverers.getCollection()) {
            sb.append(System.lineSeparator());
            sb.append(String.format(FINAL_DISCOVERER_NAME, discoverer.getName())).append(System.lineSeparator());
            sb.append(String.format(FINAL_DISCOVERER_ENERGY, discoverer.getEnergy())).append(System.lineSeparator());
            Collection<String> discovererExhibits = discoverer.getMuseum().getExhibits();
            if (discovererExhibits.isEmpty()) {
                sb.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS, "None"));
            } else {
                String allDiscoveredExhibits = String.join(FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER, discovererExhibits);
                sb.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS, allDiscoveredExhibits));
            }
        }
        return sb.toString();
    }
}
