package starbuzz.interfaces;

public abstract class CoffeeBeverage extends Beverage {

    public CoffeeBeverage(String description, Size type) {
        super(description, new CoffeeSizeFactor(type));
    }

    /**
     * Returns double with cost for beverage
     */
    public abstract double cost();

}