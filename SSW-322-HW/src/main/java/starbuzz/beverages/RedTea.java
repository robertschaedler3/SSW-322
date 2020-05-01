package starbuzz.beverages;

import starbuzz.interfaces.Size;
import starbuzz.interfaces.TeaBeverage;

public class RedTea extends TeaBeverage {

    public RedTea(Size type) {
        super("Red Tea", type);
    }

    public double cost() {
        return 0.8 + size.cost();
    }

}