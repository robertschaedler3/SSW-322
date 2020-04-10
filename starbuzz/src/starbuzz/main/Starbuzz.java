package starbuzz.main;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import starbuzz.beverages.*;
import starbuzz.ingredients.*;
import starbuzz.interfaces.*;

public class Starbuzz {

    public static Set<String> coffeeIngredients = new HashSet<>(Arrays.asList("milk", "chocolate", "whipcream"));
    public static Set<String> teaIngredients = new HashSet<>(Arrays.asList("jasmine", "ginger", "milk"));

    private static Beverage createBeverage(String[] order) {
        Beverage drink;
        switch (order[0].toLowerCase()) {
            case "espresso":
                drink = addCoffeeIngredients(order, new Espresso(), 1);
                break;
            case "decaf":
                if (order.length >= 2 && !coffeeIngredients.contains(order[1])) {
                    drink = addCoffeeIngredients(order, decafBeverage(order), 2);
                } else {
                    drink = addCoffeeIngredients(order, new Decaf(), 1);
                }
                break;
            case "houseblend":
                drink = addCoffeeIngredients(order, new HouseBlend(), 1);
                break;
            case "mocha":
                drink = addCoffeeIngredients(order, new Chocolate(new Espresso()), 1);
                break;
            case "latte":
                drink = addCoffeeIngredients(order, new Milk(new Espresso()), 1);
                break;
            case "cappucino":
                drink = addCoffeeIngredients(order, new WhipCream(new Espresso()), 1);
                break;
            case "tea":
                if (order.length > 1) {
                    drink = addTeaIngredients(order, new Milk(new RedTea()));
                    break;
                } else {
                    throw new IllegalArgumentException("Invalid beverage type.");
                }
            default:
                drink = teaBeverage(order);
        }
        return drink;
    }

    private static Beverage teaBeverage(String[] order) {
        if (order.length < 2) {
            throw new IllegalArgumentException("Invalid order.");
        }

        Beverage drink;
        switch (order[0].toLowerCase()) {
            case "green":
                drink = addTeaIngredients(order, new GreenTea());
                break;
            case "red":
                drink = addTeaIngredients(order, new RedTea());
                break;
            case "white":
                drink = addTeaIngredients(order, new WhiteTea());
                break;
            case "flower":
                drink = addTeaIngredients(order, new Jasmine(new GreenTea()));
                break;
            case "ginger":
                drink = addTeaIngredients(order, new Ginger(new GreenTea()));
                break;
            default:
                throw new IllegalArgumentException("Invlaid order.");
        }
        return drink;
    }

    private static Beverage decafBeverage(String[] order) {
        Beverage drink;
        switch (order[1].toLowerCase()) {
            case "mocha":
                drink = new Chocolate(new Decaf());
                break;
            case "latte":
                drink = new Milk(new Decaf());
                break;
            case "cappucino":
                drink = new WhipCream(new Decaf());
                break;
            default:
                throw new IllegalArgumentException("Invalid order.");
        }
        return drink;
    }

    private static Beverage addCoffeeIngredients(String[] order, Beverage drink, int orderIndex) {
        for (; orderIndex < order.length; orderIndex++) {
            switch (order[orderIndex].toLowerCase()) {
                case "chocolate":
                    drink = new Chocolate(drink);
                    break;
                case "milk":
                    drink = new Milk(drink);
                    break;
                case "whipcream":
                    drink = new WhipCream(drink);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid coffee ingredient: '" + order[orderIndex] + "'");
            }
        }
        return drink;
    }

    private static Beverage addTeaIngredients(String[] order, Beverage drink) {
        if (!order[1].equals("tea")) {
            throw new IllegalArgumentException("Invalid tea beverage.");
        }

        for (int orderIndex = 2; orderIndex < order.length; orderIndex++) {
            switch (order[orderIndex].toLowerCase()) {
                case "ginger":
                    drink = new Ginger(drink);
                    break;
                case "jasmine":
                    drink = new Jasmine(drink);
                    break;
                case "milk":
                    drink = new Milk(drink);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid tea ingredient: '" + order[orderIndex] + "'");
            }
        }
        return drink;
    }

    public static void main(String order[]) {

        if (order.length < 1) {
            System.err.println("\nUsage: <beverage name> [<ingredient 1, ingredient 2, ingredient 3>]");
            System.exit(1);
        }

        try {
            Beverage drink = createBeverage(order);
            NumberFormat fmt = NumberFormat.getCurrencyInstance();
            System.out.printf("\nThe total cost of your order is: %s\n", fmt.format(drink.cost()));
            System.out.printf("The beverage is prepared as follows: \n\n %s\n", drink.prepare());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

}