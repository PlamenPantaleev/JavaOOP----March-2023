package InterfaceAndAbstraction_04.carShopExtended;

public class CarImpl implements Car {
    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;

    private Double price;

    public CarImpl(String mode, String color, Integer horsepower, String countryProduced) {
        this.model = mode;
        this.color = color;
        this.horsePower = horsepower;
        this.countryProduced = countryProduced;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String getCountryProduced() {
        return this.countryProduced;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires", this.model, this.countryProduced, TIRES);
    }
}
