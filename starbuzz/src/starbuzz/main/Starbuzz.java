package starbuzz.main;

import java.text.NumberFormat;

import starbuzz.beverages.*;
import starbuzz.ingredients.*;
import starbuzz.interfaces.*;

public class Starbuzz {

    private static Beverage createBeverage(String[] order) {
        Beverage drink;
        switch (order[0].toLowerCase()) {
            case "espresso":
                drink = addCoffeeIngredients(order, new Espresso(), 1);
                break;
            case "decaf":
                drink = addCoffeeIngredients(order, decafBeverage(order), 2);
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
                    drink = addTeaIngredients(order, new Milk(new RedTea()), 2);
                } else {
                    throw new IllegalArgumentException("Invalid beverage type.");
                }
                break;
            default: // if no coffee beverage was found assume tea beverage
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
                drink = addTeaIngredients(order, new GreenTea(), 2);
                break;
            case "red":
                drink = addTeaIngredients(order, new RedTea(), 2);
                break;
            case "white":
                drink = addTeaIngredients(order, new WhiteTea(), 2);
                break;
            case "flower":
                drink = addTeaIngredients(order, new Jasmine(new GreenTea()), 2);
                break;
            case "ginger":
                drink = addTeaIngredients(order, new Ginger(new GreenTea()), 2);
                break;
            default:
                throw new IllegalArgumentException("Invlaid order.");
        }
        return drink;
    }

    private static Beverage decafBeverage(String[] order) {
        if (order.length < 2) {
            return new Decaf();
        }

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
                throw new IllegalArgumentException("Invalid decaf beverage.");
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

    private static Beverage addTeaIngredients(String[] order, Beverage drink, int orderIndex) {
        for (; orderIndex < order.length; orderIndex++) {
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