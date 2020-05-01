package starbuzz.interfaces;

public class TeaSizeFactor extends SizeFactor {

    public TeaSizeFactor(Size type) {
        super(type);
    }

    public double cost() {
        switch (this.type) {
            case SMALL:
                return 0.2;
            case MEDIUM:
                return 0.5;
            default:
                return 0.7;
        }
    }

}