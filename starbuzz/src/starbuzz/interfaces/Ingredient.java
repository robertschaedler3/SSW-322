package starbuzz.interfaces;

public abstract class Ingredient implements Beverage {

    /**
     * @return the beverage description.
     */
    public abstract String getDescription();

    /**
     * @return the cost of the beverage.
     */
    public abstract double getCost();

    /**
     * @return recipe instructions.
     */
    public abstract String prepare();

}