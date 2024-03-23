package FirstVariant;

import java.util.InputMismatchException;

public class BroadcastsTime implements Comparable<BroadcastsTime> {
    private byte hour;
    private byte minute;
    public BroadcastsTime(String time){
        String[] hoursAndMinutes = time.split(":");
        if (hoursAndMinutes.length != 2) throw new InputMismatchException();
        try {
            hour = (byte) Byte.parseByte(hoursAndMinutes[0]);
            minute = (byte) Byte.parseByte(hoursAndMinutes[1]);
        } catch (NumberFormatException e){
            throw new InputMismatchException();
        }
        if (hour < 0 || hour > 24 || minute < 0 || minute > 60) throw new InputMismatchException();

    }
    public byte hour() {
        return hour;
    }
    public byte minutes() {
        return minute;
    }
    boolean after(BroadcastsTime t) {
        return compareTo(t) > 0;
    }
    boolean before(BroadcastsTime t) {
        return compareTo(t) < 0;
    }
    boolean between(BroadcastsTime t1, BroadcastsTime t2) {
        return after(t1) && before(t2);
    }

    @Override
    public String toString() {
        return (hour > 10 ? hour : "0" + hour) + ":" + (minute > 10 ? minute : "0" + minute);
    }

    @Override
    public int compareTo(BroadcastsTime o) {
        return this.hour * 60 + this.minute - o.hour * 60 - minute;
    }
}