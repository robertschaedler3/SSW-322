package starbuzz.ingredients;

import starbuzz.interfaces.Beverage;
import starbuzz.interfaces.Ingredient;

public class WhipCream extends Ingredient {

    public WhipCream(Beverage beverage) {
        super(beverage, "Whip Cream");
    }

    public double cost() {
        return drink.cost() + 0.3;
    }

}