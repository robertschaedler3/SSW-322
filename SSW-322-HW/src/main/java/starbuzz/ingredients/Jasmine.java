package starbuzz.ingredients;

import starbuzz.interfaces.Beverage;
import starbuzz.interfaces.Ingredient;

public class Jasmine extends Ingredient {

    public Jasmine(Beverage beverage) {
        super(beverage, "Jasmine");
    }

    public double cost() {
        return drink.cost() + 0.3;
    }

}