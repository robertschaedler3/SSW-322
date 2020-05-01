package starbuzz.beverages;

import starbuzz.interfaces.Size;
import starbuzz.interfaces.TeaBeverage;

public class WhiteTea extends TeaBeverage {

    public WhiteTea(Size type) {
        super("White Tea", type);
    }

    public double cost() {
        return 1.0 + size.cost();
    }

}