package computer.standard;

import computer.interfaces.*;

public class StandardComputerPartsFactory implements ComputerPartsFactory {

    public Monitor createMonitor() {
        return new StandardMonitor();
    }

    public CPU createCPU() {
        return new StandardCPU();
    }

    public Keyboard createKeyboard() {
        return new StandardKeyboard();
    }

}