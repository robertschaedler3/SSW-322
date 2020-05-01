package starbuzz.interfaces;

public abstract class Beverage {

    protected String description;
    protected SizeFactor size;

    // public Beverage(String description) {
    // this.description = description;
    // this.size =
    // }

    public Beverage(String description, SizeFactor size) {
        this.description = description;
        this.size = size;
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