package starbuzz.beverages;

import starbuzz.interfaces.TeaBeverage;

public class RedTea extends TeaBeverage {

    public RedTea() {
        super("Red Tea");
    }

    public double cost() {
        return 0.8;
    }

}