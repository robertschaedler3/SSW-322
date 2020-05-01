package starbuzz.interfaces;

public class CoffeeSizeFactor extends SizeFactor {

    public CoffeeSizeFactor(Size type) {
        super(type);
    }

    public double cost() {
        switch (this.type) {
            case SMALL:
                return 0.4;
            case MEDIUM:
                return 0.7;
            default:
                return 1.0;
        }
    }

}