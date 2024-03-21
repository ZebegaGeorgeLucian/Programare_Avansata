package org.example;
import java.util.List;
import java.time.LocalTime;
public interface Visitable {
    String getOpenDays();
    LocalTime getOpeningHours();
    LocalTime getClosingHours();

    default LocalTime getOpeningHourForDay(String day){
        String uppercaseDay = day.toUpperCase();
        if(getOpenDays().contains(uppercaseDay)){
            return getOpeningHours();
        } else {
            return null;
        }
    }
}