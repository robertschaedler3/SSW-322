package starbuzz.interfaces;

public abstract class TeaBeverage extends Beverage {

    public TeaBeverage(String description) {
        super(description);
    }

    /**
     * Returns double with cost for beverage
     */
    public abstract double cost();

}