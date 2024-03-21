package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Trip trip1 = new Trip("3 days", "Paris");
        Statue statue = new Statue("Statue of Liberty", "Iconic symbol of freedom");
        Church church1 = new Church("Notre-Dame", "Gothic cathedral", "Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday",
                LocalTime.parse("10:00"), LocalTime.parse("17:30"));
        Concert concert = new Concert("Concert Hall", "Symphony Orchestra Performance", "Friday,Sunday",
                LocalTime.parse("19:00"), LocalTime.parse("22:00"), 50);
        Church church2 = new Church("Sainte-Chapelle", "a royal chapel in the Gothic style", "Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday",
                LocalTime.parse("10:30"), LocalTime.parse("17:00"));

        trip1.addAttraction(statue);
        trip1.addAttraction(church1);
        trip1.addAttraction(concert);
        trip1.addAttraction(church2);

        System.out.println(trip1.toString());

        // Crearea planului de călătorie
        TravelPlan travelPlan = new TravelPlan();
        travelPlan.addVisit(church1, LocalDate.of(2024, 3, 20));
        travelPlan.addVisit(statue, LocalDate.of(2024, 3, 20));
        travelPlan.addVisit(church2, LocalDate.of(2024, 3, 21));
        travelPlan.addVisit(concert, LocalDate.of(2024, 3, 22));

        System.out.println(travelPlan);
    }
}