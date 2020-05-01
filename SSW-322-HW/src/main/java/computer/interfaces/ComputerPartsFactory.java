package computer.interfaces;

public interface ComputerPartsFactory {

    /**
     * Creates a monitor.
     * 
     * @return Monitor
     */
    public Monitor createMonitor();

    /**
     * Creates a CPU
     * 
     * @return CPU
     */
    public CPU createCPU();

    /**
     * Creates a keyboard.
     * 
     * @return Keyboard
     */
    public Keyboard createKeyboard();

}