package org.example;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TravelPlan {
    private Map<Object, LocalDate> plan;

    public TravelPlan() {
        this.plan = new HashMap<>();
    }

    public void addVisit(Object attraction, LocalDate date) {
        plan.put(attraction, date);
    }

    public LocalDate getVisitDate(Object attraction) {
        return plan.get(attraction);
    }

    @Override
    public String toString() {
        return "TravelPlan{" +
                "plan=" + plan +
                '}';
    }
}