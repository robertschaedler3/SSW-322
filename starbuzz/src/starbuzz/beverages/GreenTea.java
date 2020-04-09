package starbuzz.beverages;

import starbuzz.interfaces.TeaBeverage;

public class GreenTea extends TeaBeverage {

    public GreenTea() {
        super("Green Tea");
    }

    public double cost() {
        return 1.0;
    }

}