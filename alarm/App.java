package alarm;

import java.util.concurrent.TimeUnit;
import java.util.Calendar;
import java.util.Date;

public class App {

    public static void main(String[] args) throws InterruptedException {

        // set an alarm for 5 min from now
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.MINUTE, 5);

        AlarmClock clock = new AlarmClock();
        clock.setAlarm(cal.getTime());

        while (true) {

            clock.displayTime();

            if (clock.isAlarmTime()) {
                clock.signalAlarm();
                clock.snooze();
            }

            clock.tick();
            TimeUnit.SECONDS.sleep(1);

        }
    }

}