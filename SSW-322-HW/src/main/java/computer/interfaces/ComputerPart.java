package computer.interfaces;

public abstract class ComputerPart {

    protected double price;

    public ComputerPart(double price) {
        this.price = price;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

}