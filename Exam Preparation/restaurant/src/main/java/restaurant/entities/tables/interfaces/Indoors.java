package restaurant.entities.tables.interfaces;

import restaurant.entities.tables.BaseTable;

public class Indoors extends BaseTable {
    private static final double PRICE_FOR_PERSON = 3.50;
    public Indoors(int number, int size) {
        super(number, size, PRICE_FOR_PERSON);
    }
}
