package starbuzz.beverages;

import starbuzz.interfaces.CoffeeBeverage;
import starbuzz.interfaces.Size;

public class Espresso extends CoffeeBeverage {

    public Espresso(Size type) {
        super("Espresso", type);
    }

    public double cost() {
        return 1.0 + size.cost();
    }

}