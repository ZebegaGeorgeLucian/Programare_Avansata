package org.example;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Church implements Visitable{
    String name;
    String description;
    String openDays;
    LocalTime openingHours;
    LocalTime closingHours;

    Church(String name, String description, String openDays, LocalTime openingHours, LocalTime closingHour){
        this.name = name;
        this.description = description;
        this.openDays = openDays;
        this.openingHours = openingHours;
        this.closingHours = closingHours;
    }

    public String getName() {
        return name;
    }
    public String getDescription(){
        return description;
    }
    @Override
    public String getOpenDays(){
        return openDays;
    }
    @Override
    public LocalTime getOpeningHours(){
        return openingHours;
    }
    @Override
    public LocalTime getClosingHours(){
        return closingHours;
    }
    @Override
    public LocalTime getOpeningHourForDay(String day){
        DayOfWeek dayOfWeek = DayOfWeek.valueOf(day.toUpperCase());
        if(getOpenDays().contains(day.toUpperCase())){
            return getOpeningHours();
        } else {
            return null;
        }
    }
    @Override
    public String toString(){
        return "Church{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", openDays='" + openDays + '\'' +
                ", openingHours='" + openingHours + '\'' +
                ", closingHours='" + closingHours + '\'' +
                '}';
    }
}
