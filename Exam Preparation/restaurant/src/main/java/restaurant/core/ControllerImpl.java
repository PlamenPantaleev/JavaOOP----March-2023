package restaurant.core;

import restaurant.common.enums.BeveragesType;
import restaurant.common.enums.HealthyFoodType;
import restaurant.common.enums.TableType;
import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.Fresh;
import restaurant.entities.drinks.Smoothie;
import restaurant.entities.healthyFoods.Salad;
import restaurant.entities.healthyFoods.VeganBiscuits;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.tables.InGarden;
import restaurant.entities.tables.interfaces.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.*;

import static restaurant.common.ExceptionMessages.*;
import static restaurant.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private HealthFoodRepository<HealthyFood> healthFoodRepository;
    private BeverageRepository<Beverages> beverageRepository;
    private TableRepository<Table> tableRepository;
    private double totalMoney;

    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {
        this.healthFoodRepository = healthFoodRepository;
        this.beverageRepository = beverageRepository;
        this.tableRepository = tableRepository;
        this.totalMoney = 0;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        HealthyFood healthyFood = healthFoodRepository.foodByName(name);
        if (healthyFood == null) {
            HealthyFoodType healthyFoodType = HealthyFoodType.valueOf(type);
            switch (healthyFoodType) {
                case Salad:
                    healthyFood = new Salad(name, price);
                    break;
                case VeganBiscuits:
                    healthyFood = new VeganBiscuits(name, price);
                    break;
                default:
                    throw new IllegalArgumentException("No such type!");
            }
            healthFoodRepository.add(healthyFood);
            return String.format(FOOD_ADDED, name);
        } else {
            throw new IllegalArgumentException(String.format(FOOD_EXIST, name));
        }
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name) {
        Beverages beverages = beverageRepository.beverageByName(name, brand);
        if (beverages == null) {
            BeveragesType beveragesType = BeveragesType.valueOf(type);
            switch (beveragesType) {
                case Smoothie:
                    beverages = new Smoothie(name, counter, brand);
                    break;
                case Fresh:
                    beverages = new Fresh(name, counter, brand);
                    break;
                default:
                    throw new IllegalArgumentException("No such type!");
            }
            beverageRepository.add(beverages);
            return String.format(BEVERAGE_ADDED, type, brand);
        } else {
            throw new IllegalArgumentException(String.format(BEVERAGE_EXIST, name));
        }
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table;
        TableType tableType = TableType.valueOf(type);
        switch (tableType) {
            case Indoors:
                table = new Indoors(tableNumber, capacity);
                break;
            case InGarden:
                table = new InGarden(tableNumber, capacity);
                break;
            default:
                throw new IllegalArgumentException("No such type!");
        }
        if (tableRepository.byNumber(tableNumber) != null) {
            throw new IllegalArgumentException(String.format(TABLE_IS_ALREADY_ADDED, tableNumber));
        }
        tableRepository.add(table);
        return String.format(TABLE_ADDED, tableNumber);

    }

    @Override
    public String reserve(int numberOfPeople) {
        Table availableTable = tableRepository.getAllEntities()
                .stream().filter(t -> !t.isReservedTable() && t.getSize() >= numberOfPeople)
                .findFirst().orElse(null);
        if (availableTable == null) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        } else {
            availableTable.reserve(numberOfPeople);
            return String.format(TABLE_RESERVED, availableTable.getTableNumber(), numberOfPeople);
        }
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        Table table = tableRepository.byNumber(tableNumber);
        HealthyFood healthyFood = healthFoodRepository.foodByName(healthyFoodName);
        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        } else if (healthyFood == null) {
            return String.format(NONE_EXISTENT_FOOD, healthyFoodName);
        } else {
            table.orderHealthy(healthyFood);
            return String.format(FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);
        }
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        Table table = tableRepository.byNumber(tableNumber);
        Beverages beverages = beverageRepository.beverageByName(name, brand);
        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        } else if (beverages == null) {
            return String.format(NON_EXISTENT_DRINK, name, brand);
        } else {
            table.orderBeverages(beverages);
            return String.format(BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);
        }
    }

    @Override
    public String closedBill(int tableNumber) {
        Table table = tableRepository.byNumber(tableNumber);
        double bill = table.bill();
        totalMoney += bill;
        return String.format(BILL, tableNumber, bill);
    }


    @Override
    public String totalMoney() {
        return String.format(TOTAL_MONEY, totalMoney);
    }
}
