package alarm;

import java.util.Date;
import java.util.Calendar;

class Clock {

    private Date date;
    protected Calendar cal;

    public Clock() {
        this.date = new Date();
        this.cal = Calendar.getInstance();
        cal.setTime(this.date);
    }

    public void tick() {
        this.cal.add(Calendar.SECOND, 1);
    }

    public void displayTime() {
        int hour = this.cal.get(Calendar.HOUR);
        int min = this.cal.get(Calendar.MINUTE);
        int sec = this.cal.get(Calendar.SECOND);
        System.out.printf("%2s:%2s:%2s\n", hour, min, sec);
    }
}
