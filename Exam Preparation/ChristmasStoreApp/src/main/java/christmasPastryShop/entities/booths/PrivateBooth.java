package christmasPastryShop.entities.booths;

public class PrivateBooth extends BaseBooth {
    private static final double PRICE_FOR_PERSON = 3.50;
    public PrivateBooth(int boothNumber, int capacity) {
        super(boothNumber, capacity, PRICE_FOR_PERSON);
    }
}
