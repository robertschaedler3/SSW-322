package starbuzz.beverages;

import starbuzz.interfaces.CoffeeBeverage;

public class Espresso extends CoffeeBeverage {

    public Espresso() {
        super("Espresso");
    }

    public double cost() {
        return 1.0;
    }

}