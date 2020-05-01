package starbuzz.beverages;

import starbuzz.interfaces.CoffeeBeverage;
import starbuzz.interfaces.Size;

public class Decaf extends CoffeeBeverage {

    public Decaf(Size type) {
        super("Decaf", type);
    }

    public double cost() {
        return 0.5 + size.cost();
    }

}