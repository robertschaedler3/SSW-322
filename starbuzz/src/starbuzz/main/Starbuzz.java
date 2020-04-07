package starbuzz.main;

public class Starbuzz {

    public static void main(String args[]) {
        if (args.length < 2) {
            System.err.println("Usage: <beverage name> [<ingredient 1, ingredient 2, ingredient 3>]");
        }

        System.out.printf("Name: %s\n", args[0]);
        for (int i = 1; i < args.length; i++) {
            System.out.printf("Ingredient: %s\n", args[i]);
        }
    }

}