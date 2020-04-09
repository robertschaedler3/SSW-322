package starbuzz.interfaces;

public abstract class CoffeeBeverage extends Beverage {

    public CoffeeBeverage(String description) {
        super(description);
    }

    /**
     * Returns double with cost for beverage
     */
    public abstract double cost();

}