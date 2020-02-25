package alarm;

import java.util.Date;
import java.util.Calendar;

class AlarmClock extends Clock {

    private Date alarm;
    private Calendar alarmCal;

    private Radio radio;

    public AlarmClock() {
        super();
        this.radio = new Radio();
        this.alarmCal = Calendar.getInstance();
    }

    public AlarmClock(Date alarm) {
        super();
        this.radio = new Radio();
        this.alarm = alarm;
        this.alarmCal = Calendar.getInstance();
        alarmCal.setTime(this.alarm);
    }

    boolean isAlarmTime() {
        if (alarm == null)
            return false;
        return this.alarmCal.get(Calendar.HOUR) == super.cal.get(Calendar.HOUR)
                && this.alarmCal.get(Calendar.MINUTE) == super.cal.get(Calendar.MINUTE)
                && this.alarmCal.get(Calendar.SECOND) == super.cal.get(Calendar.SECOND);
    }

    public void signalAlarm() {
        System.out.println("BUZZ BUZZ BUZZ");
        this.radio.turnOn();
    }

    public void snooze() {
        if (this.radio.isOn()) {
            this.alarmCal.add(Calendar.MINUTE, 9);
            System.out.println("Snoozing for 9 minutes.");
            this.radio.turnOff();
        }
    }

    public void setAlarm(Date time) {
        this.alarm = time;
        this.alarmCal.setTime(this.alarm);
    }

    public void deleteAlarm() {
        if (this.alarm == null)
            throw new IllegalStateException();
        this.alarm = null;
    }

}
