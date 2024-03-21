package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
public class VisitingTime {
    private Map<LocalDate, List<LocalTime>> timetable;
    public VisitingTime(){
        this.timetable = new HashMap<>();
    }
    public void setTimetable(Map<LocalDate, List<LocalTime>> timetable) {
        this.timetable = timetable;
    }
    public void addVisitingTime(LocalDate date, List<LocalTime> visitingTimes){
        timetable.put(date, visitingTimes);
    }
    public List<LocalTime> getVisitingTime(LocalDate date) {
        return timetable.getOrDefault(date, new ArrayList<>());
    }
}