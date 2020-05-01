package starbuzz.beverages;

import starbuzz.interfaces.CoffeeBeverage;
import starbuzz.interfaces.Size;

public class HouseBlend extends CoffeeBeverage {

    public HouseBlend(Size type) {
        super("Houseblend", type);
    }

    public double cost() {
        return 0.8 + size.cost();
    }
}