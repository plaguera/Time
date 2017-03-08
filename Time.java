package time;

/**
 * Programación de Aplicaciones Interactivas: Práctica 5 - Game Of Life
 * @author Pedro Miguel Lagüera Cabrera
 * Email: laguerapedro@gmail.com
 * Mar 7, 2017
 * Time.java
 */
public class Time {

		private final static int MAX_HOUR = 24;
		private final static int MAX_MIN = 60;
		private final static int MAX_SEC = 60;

		private int hour   = 0;
    private int minute = 0;
    private int second = 0;

    public Time(int second, int minute, int hour) {
        setTime(second, minute, hour);
    }

    public void setTime(int second, int minute, int hour) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    /** @return the hour */
    public int getHour() {
        return hour;
    }

    /** @return the minute */
    public int getMinute() {
        return minute;
    }

    /** @return the second */
    public int getSecond() {
        return second;
    }

    /** @param new hour value [0-23] */
    public void setHour(int hour) {
        if (hour < 0 || hour >= MAX_HOUR)
            throw new IllegalArgumentException("Not valid hour value");
        this.hour = hour;
    }

    /** @param new minute value [0-59] */
    public void setMinute(int minute) {
        if (minute < 0 || minute >= MAX_MIN)
            throw new IllegalArgumentException("Not valid minute value");
        this.minute = minute;
    }

    /** @param new second value [0-59] */
    public void setSecond(int second) {
        if (second < 0 || second >= MAX_SEC)
            throw new IllegalArgumentException("Not valid second value");
        this.second = second;
    }

    /** @return instance of class of next second */
    public Time nextSecond() {
        try {
            setTime(++second, minute, hour);
            return this;
        }
        catch(IllegalArgumentException e) {}

        second = 0;
        return nextMinute();
    }

    /** @return instance of class of next minute */
    public Time nextMinute() {
        try {
            setTime(second, ++minute, hour);
            return this;
        }
        catch(IllegalArgumentException e) {}

        minute = 0;
        return nextHour();
    }

    /** @return instance of class of next hour */
    public Time nextHour() {
        try {
            setTime(second, minute, ++hour);
            return this;
        }
        catch(IllegalArgumentException e) {}

        hour = 0;
        return this;
    }

    /** @return instance of class of previous second */
    public Time previousSecond() {
        try {
            setTime(--second, minute, hour);
            return this;
        }
        catch(IllegalArgumentException e) {}

        second = MAX_SEC-1;
        return previousMinute();
    }

    /** @return instance of class of previous minute */
    public Time previousMinute() {
        try {
            setTime(second, --minute, hour);
            return this;
        }
        catch(IllegalArgumentException e) {}

        minute = MAX_MIN-1;
        return previousHour();
    }

    /** @return instance of class of previous hour */
    public Time previousHour() {
        try {
            setTime(second, minute, --hour);
            return this;
        }
        catch(IllegalArgumentException e) {}

        hour = MAX_HOUR-1;
        return this;
    }

    public String toString() {
    	return hour + ":" + minute + ":" + second;
    }

}
