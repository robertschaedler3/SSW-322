package starbuzz.interfaces;

public abstract class Beverage {

    private String description;

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
    protected String getDescription() {
        return description;
    }

    /**
     * @return the cost of the beverage.
     */
    public abstract double cost();

}