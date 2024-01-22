package christmasPastryShop.entities.booths;

public class OpenBooth extends BaseBooth{
    private static final double PRICE_FOR_PERSON = 2.50;
    public OpenBooth(int boothNumber, int capacity) {
        super(boothNumber, capacity, PRICE_FOR_PERSON);
    }
}
