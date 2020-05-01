package starbuzz.interfaces;

public abstract class Ingredient extends Beverage {

    protected Beverage drink;

    public Ingredient(Beverage beverage, String descripton) {
        super(descripton, beverage.size);
        this.drink = beverage;
    }

    /**
     * @return recipe instructions.
     */
    public String prepare() {
        return this.drink.prepare() + " \tadd " + this.getDescription() + "\n\t";
    }

    /**
     * @return the beverage description.
     */
    public String getDescription() {
        return super.getDescription();
    }

    /**
     * @return the cost of the beverage.
     */
    public abstract double cost();

}