package alarm;

public class Radio {

    private boolean state = false;
    private int volume = 0;
    private double station = 102.7;

    public void setVolume(int volume) {
        if (volume < 0 || volume > 10)
            throw new IllegalArgumentException();
        this.volume = volume;
    }

    public int getVolume() {
        return this.volume;
    }

    public void setStation(double station) {
        if (station < 88.0 || station > 108.0)
            throw new IllegalArgumentException();
        this.station = station;
    }

    public double getStation() {
        return this.station;
    }

    public boolean isOn() {
        return state;
    }

    public void turnOn() {
        this.state = true;
    }

    public void turnOff() {
        this.state = false;
    }

    public boolean toggleOnOff() {
        this.state = !this.state;
        return this.state;
    }

}