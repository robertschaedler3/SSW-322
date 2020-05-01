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
        Size type;
        switch (order[0].toLowerCase()) {
            case "espresso":
                type = getSize(order, 1);
                drink = addCoffeeIngredients(order, new Espresso(type), 2);
                break;
            case "houseblend":
                type = getSize(order, 1);
                drink = addCoffeeIngredients(order, new HouseBlend(type), 2);
                break;
            case "mocha":
                type = getSize(order, 1);
                drink = addCoffeeIngredients(order, new Chocolate(new Espresso(type)), 2);
                break;
            case "latte":
                type = getSize(order, 1);
                drink = addCoffeeIngredients(order, new Milk(new Espresso(type)), 2);
                break;
            case "cappucino":
                type = getSize(order, 1);
                drink = addCoffeeIngredients(order, new WhipCream(new Espresso(type)), 2);
                break;
            case "decaf":
                if (order.length >= 3 && !coffeeIngredients.contains(order[2])) {
                    type = getSize(order, 2);
                    drink = addCoffeeIngredients(order, decafBeverage(order), 3);
                } else {
                    type = getSize(order, 1);
                    drink = addCoffeeIngredients(order, new Decaf(type), 2);
                }
                break;
            case "tea":
                if (order.length >= 3 && order[1].equals("latte")) {
                    type = getSize(order, 2);
                    drink = addTeaIngredients(order, new Milk(new RedTea(type)));
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
        if (order.length < 3) {
            throw new IllegalArgumentException("Invalid order.");
        }

        Beverage drink;
        Size type = getSize(order, 2);
        switch (order[0].toLowerCase()) {
            case "green":
                drink = addTeaIngredients(order, new GreenTea(type));
                break;
            case "red":
                drink = addTeaIngredients(order, new RedTea(type));
                break;
            case "white":
                drink = addTeaIngredients(order, new WhiteTea(type));
                break;
            case "flower":
                drink = addTeaIngredients(order, new Jasmine(new GreenTea(type)));
                break;
            case "ginger":
                drink = addTeaIngredients(order, new Ginger(new GreenTea(type)));
                break;
            default:
                throw new IllegalArgumentException("Invalid order.");
        }
        return drink;
    }

    private static Beverage decafBeverage(String[] order) {
        Size type = getSize(order, 2);
        Beverage drink = new Decaf(type);
        switch (order[1].toLowerCase()) {
            case "mocha":
                drink = new Chocolate(drink);
                break;
            case "latte":
                drink = new Milk(drink);
                break;
            case "cappucino":
                drink = new WhipCream(drink);
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

        for (int orderIndex = 3; orderIndex < order.length; orderIndex++) {
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

    private static Size getSize(String[] order, int index) {
        switch (order[index].toLowerCase()) {
            case "small":
                return Size.SMALL;
            case "medium":
                return Size.MEDIUM;
            case "large":
                return Size.LARGE;
            default:
                throw new IllegalArgumentException("Invalid size given.");
        }
    }

    public static void main(String order[]) {

        if (order.length < 2) {
            System.err.println("\nUsage: <beverage name> <size> [<ingredient 1, ingredient 2, ingredient 3>]");
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