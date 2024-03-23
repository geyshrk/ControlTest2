package FirstVariant;
public class BroadcastsTime implements Comparable<BroadcastsTime> {
    private byte hour;
    private byte minute;

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
    public int compareTo(BroadcastsTime o) {
        return this.hour * 60 + this.minute - o.hour * 60 - minute;
    }
}