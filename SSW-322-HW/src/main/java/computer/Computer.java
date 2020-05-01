package computer;

import java.text.NumberFormat;

import computer.interfaces.*;
import computer.standard.StandardComputerPartsFactory;
import computer.advanced.AdvancedComputerPartsFactory;

public class Computer {

    private static CPU cpu;
    private static Monitor monitor;
    private static Keyboard keyboard;

    private static ComputerPartsFactory factory;

    private static void createComputer() {
        cpu = factory.createCPU();
        monitor = factory.createMonitor();
        keyboard = factory.createKeyboard();
    }

    private static double getPrice() {
        return cpu.getPrice() + monitor.getPrice() + keyboard.getPrice();
    }

    public static void main(String args[]) {

        if (args.length != 1) {
            System.err.println("Usage: <standard | advanced>");
            return;
        }

        switch (args[0].toLowerCase()) {
            case "standard":
                factory = new StandardComputerPartsFactory();
                break;
            case "advanced":
                factory = new AdvancedComputerPartsFactory();
                break;
            default:
                System.err.printf("Invalid computer type: '%s'\n", args[0]);
                return;
        }

        createComputer();

        String computerType = args[0].substring(0, 1).toUpperCase() + args[0].substring(1);
        NumberFormat fmt = NumberFormat.getCurrencyInstance();

        System.out.printf("\nCreated '%s Computer': %s\n", computerType, fmt.format(getPrice()));

    }

}