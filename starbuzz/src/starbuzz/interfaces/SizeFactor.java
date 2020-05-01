package starbuzz.interfaces;

public abstract class SizeFactor {

    protected Size type;

    public SizeFactor(Size type) {
        this.type = type;
    }

    public abstract double cost();

}