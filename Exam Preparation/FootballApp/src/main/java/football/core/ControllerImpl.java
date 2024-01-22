package football.core;


import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static football.common.ConstantMessages.*;
import static football.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private SupplementRepository supplement;
    private Map<String, Field> fields;

    public ControllerImpl() {
        this.supplement = new SupplementRepositoryImpl();
        this.fields = new LinkedHashMap<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        Field f;
        if (fieldType.equals("ArtificialTurf")) {
            f = new ArtificialTurf(fieldName);
        } else if (fieldType.equals("NaturalGrass")) {
            f = new NaturalGrass(fieldName);
        } else {
            throw new NullPointerException(INVALID_FIELD_TYPE);
        }
        fields.put(fieldName, f);
        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        if (type.equals("Powdered")) {
            Supplement supplement1 = new Powdered();
            supplement.add(supplement1);
        } else if (type.equals("Liquid")) {
            Supplement supplement1 = new Liquid();
            supplement.add(supplement1);
        } else {
            throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Supplement s = supplement.findByType(supplementType);

        if (s == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }
        Field field = fields.get(fieldName);
        field.addSupplement(s);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player player;
        if (playerType.equals("Men")) {
            player = new Men(playerName, nationality, strength);
        } else if (playerType.equals("Women")) {
            player = new Women(playerName, nationality, strength);
        } else {
            throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }
        String output;
        Field field = fields.get(fieldName);
        if (!playerCanPlayOnFieldType(playerType, field)) {
            output = FIELD_NOT_SUITABLE;
        } else {
            field.addPlayer(player);
            output = String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
        }
        return output;
    }

    private boolean playerCanPlayOnFieldType(String playerType, Field field) {
        String fieldType = field.getClass().getSimpleName();
        boolean canPlay = playerType.equals("Women") && fieldType.equals("ArtificialTurf");
        if (!canPlay) {
            canPlay = playerType.equals("Men") && fieldType.equals("NaturalGrass");
        }
        return canPlay;
    }

    @Override
    public String dragPlayer(String fieldName) {
        Field field = fields.get(fieldName);
        field.drag();
        return String.format(PLAYER_DRAG, field.getPlayers().size());
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field field = fields.get(fieldName);
        int strength = field.getPlayers().stream().mapToInt(Player::getStrength).sum();
        return String.format(STRENGTH_FIELD,fieldName, strength);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        for (Field value : fields.values()) {
            sb.append(value.getInfo()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
