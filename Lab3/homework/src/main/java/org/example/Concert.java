package org.example;

import java.time.DayOfWeek;
import java.time.LocalTime;
public class Concert implements Visitable,Payable{
    String openDays;
    LocalTime openingHours;
    LocalTime closingHours;
    int entryFree;
    String name;
    String description;

    Concert(String name, String description, String openDays, LocalTime openingHours,LocalTime closingHours, int entryFree){
        this.name = name;
        this.description = description;
        this.openDays = openDays;
        this.openingHours = openingHours;
        this.closingHours = closingHours;
        this.entryFree = entryFree;
    }
    public String getName(){
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
        return "Concert{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", openDays='" + openDays + '\'' +
                ", openingHours='" + openingHours + '\'' +
                ", closingHours='" + closingHours + '\'' +
                ", entryFree= "+ entryFree +
                '}';
    }

    @Override
    public double getEntryFee() {
        return entryFree;
    }
}
