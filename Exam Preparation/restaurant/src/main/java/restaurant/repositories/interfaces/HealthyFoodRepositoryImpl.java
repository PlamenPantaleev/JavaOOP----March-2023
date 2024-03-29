package restaurant.repositories.interfaces;

import restaurant.entities.healthyFoods.interfaces.HealthyFood;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class HealthyFoodRepositoryImpl implements HealthFoodRepository<HealthyFood>{
    private Collection<HealthyFood> healthyFoods;

    public HealthyFoodRepositoryImpl() {
        this.healthyFoods = new ArrayList<>();
    }

    @Override
    public HealthyFood foodByName(String name) {
        return healthyFoods.stream().filter(f -> f.getName().equals(name))
                .findFirst().orElse(null);
    }

    @Override
    public Collection<HealthyFood> getAllEntities() {
        return Collections.unmodifiableCollection(healthyFoods);
    }

    @Override
    public void add(HealthyFood entity) {
        healthyFoods.add(entity);
    }
}
