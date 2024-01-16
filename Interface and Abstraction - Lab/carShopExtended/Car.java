package InterfaceAndAbstraction_04.carShopExtended;

import java.io.Serializable;

public interface Car extends Serializable {
    int TIRES = 4;

    String getModel();

    String getColor();

    Integer getHorsePower();

    String getCountryProduced();
}
