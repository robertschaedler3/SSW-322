package starbuzz.ingredients;

import starbuzz.interfaces.Beverage;
import starbuzz.interfaces.Ingredient;

public class Milk extends Ingredient {

    public Milk(Beverage beverage) {
        super(beverage, "Milk");
    }

    public double cost() {
        return drink.cost() + 0.3;
    }

}