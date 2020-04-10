package starbuzz.interfaces;

public abstract class Beverage {

    protected String description;

    public Beverage(String description) {
        this.description = description;
    }

    /**
     * @return recipe instructions.
     */
    public String prepare() {
        return "\t" + getDescription() + "\n\t";
    }

    /**
     * @return the beverage description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the cost of the beverage.
     */
    public abstract double cost();

}