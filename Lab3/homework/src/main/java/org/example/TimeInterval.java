package org.example;

import java.time.Duration;
import java.sql.Time;
import java.time.LocalTime;

public class TimeInterval<T extends LocalTime> {
    private T startTime;
    private T endTime;

    public TimeInterval(T startTime, T endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public T getStartTime(){
        return startTime;
    }
    public void setStartTime(T startTime) {
        this.startTime = startTime;
    }

    public T getEndTime() {
        return endTime;
    }

    public void setEndTime(T endTime) {
        this.endTime = endTime;
    }
    public Duration calculateDuration() {
        return Duration.between(startTime, endTime);
    }

    @Override
    public String toString() {
        return "TimeInterval{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}