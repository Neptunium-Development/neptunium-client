package me.corruptionhades.vapemenu.utils.time;

public class TimerUtilHelper {

    private long lastMS;

    public TimerUtilHelper() {
        this.reset();
    }

    public long getCurrentMS() {
        return System.nanoTime() / 1000000L;
    }

    public boolean hasReached(final double milliseconds) {
        return this.getCurrentMS() - this.lastMS >= milliseconds;
    }

    public void reset() {
        this.lastMS = this.getCurrentMS();
    }

    public boolean delay(final float milliSec) {
        return this.getTime() - this.lastMS >= milliSec;
    }

    public long getTime() {
        return System.nanoTime() / 1000000L;
    }
}