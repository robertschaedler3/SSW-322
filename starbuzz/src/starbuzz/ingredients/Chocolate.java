package starbuzz.ingredients;

import starbuzz.interfaces.Beverage;
import starbuzz.interfaces.Ingredient;

public class Chocolate extends Ingredient {

    public Chocolate(Beverage beverage) {
        super(beverage, "Chocolate");
    }

    public double cost() {
        return drink.cost() + 0.3;
    }

}