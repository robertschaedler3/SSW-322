package computer.advanced;

import computer.interfaces.*;

public class AdvancedComputerPartsFactory implements ComputerPartsFactory {

    public Monitor createMonitor() {
        return new AdvancedMonitor();
    }

    public CPU createCPU() {
        return new AdvancedCPU();
    }

    public Keyboard createKeyboard() {
        return new AdvancedKeyboard();
    }

}