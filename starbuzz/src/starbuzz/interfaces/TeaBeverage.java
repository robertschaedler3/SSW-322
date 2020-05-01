package starbuzz.interfaces;

public abstract class TeaBeverage extends Beverage {

    public TeaBeverage(String description, Size type) {
        super(description, new TeaSizeFactor(type));
    }

    /**
     * Returns double with cost for beverage
     */
    public abstract double cost();

}