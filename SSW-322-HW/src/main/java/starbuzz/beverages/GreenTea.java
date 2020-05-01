package starbuzz.beverages;

import starbuzz.interfaces.Size;
import starbuzz.interfaces.TeaBeverage;

public class GreenTea extends TeaBeverage {

    public GreenTea(Size type) {
        super("Green Tea", type);
    }

    public double cost() {
        return 1.0 + size.cost();
    }

}