import jdk.jfr.Timespan;

import java.sql.Time;
import java.util.Objects;

public class TimeSpan implements Comparable<TimeSpan> {
    private int hours;
    private int minutes;

    private TimeSpan(int hours, int minutes){
        this.hours = hours;
        this.minutes = minutes;
        timeNormalization();
    }

    // helper method to add time correctly
    private void timeNormalization(){
        if (this.minutes >= 60){
            this.hours += minutes / 60;
            this.minutes %= 60;
        }
    }

    public static TimeSpan ofHours(int hours){
        if (hours < 0){
            throw new IllegalArgumentException("Hours can not be negative");
        }
        // ima just assume minutes are 0 by default
        return new TimeSpan(hours, 0);
    }

    public static TimeSpan ofMinutes(int totalMinutes){
        if (totalMinutes < 0) {
            throw new IllegalArgumentException("Minutes can not be negative");
        }
        // ima assume hours are 0 by default too?
        return new TimeSpan(0, totalMinutes);
    }

    public static TimeSpan ofHoursAndMinutes(int hours, int minutes){
        if (hours < 0 || minutes < 0){
            throw new IllegalArgumentException("Hours and Minutes can not be negative");
        }
        return new TimeSpan(hours, minutes);
    }

    public int getHours(){
        return hours;
    }

    public int getMinutes(){
        return minutes % 60;
    }
    public int getTotalMinutes(){
        return hours * 60 + minutes;
    }

    @Override
    public String toString(){
        return hours + "h" + minutes + "m";
    }

    //template for equals method
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TimeSpan) {
            TimeSpan that = (TimeSpan) obj;
            return this.hours == that.hours && this.minutes == that.minutes;
        } else {
            return false;
        }
    }

    //template can also use for hash code
    @Override
    public int hashCode() {
        int result = Objects.hash(hours, minutes);
        return result;
    }

    public TimeSpan plus(TimeSpan other){
        return new TimeSpan(this.hours + other.hours, this.minutes + other.minutes);
    }

    public TimeSpan plusHours(int hours){
        if (hours < 0){
            throw new IllegalArgumentException("Hour cant be negative");
        }
        return new TimeSpan(this.hours + hours, this.minutes);
    }

    public TimeSpan plusMinutes(int minutes){
        if (minutes < 0){
            throw new IllegalArgumentException("Minutes cant be negative");
        }
        return new TimeSpan(this.hours,this.minutes + minutes);
    }

    public TimeSpan plusHoursAndMinutes(int hours, int minutes){
        if (hours < 0 || minutes < 0) {
            throw new IllegalArgumentException("Hours and minutes cannot be negative");
        }
        return new TimeSpan(this.hours + hours, this.minutes + minutes);
    }

    //best way to use compareTo
    //use this if you need something in specific to compare to
    @Override
    public int compareTo(TimeSpan other) {
        return Integer.compare(this.getTotalMinutes(), other.getTotalMinutes());

    }
}
