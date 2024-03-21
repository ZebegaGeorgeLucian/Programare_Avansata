package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Trip {
    String periodOfTime;
    String cityName;
    List<Object> attractions;
    public Trip( String periodOfTime ,String cityName){
        this.periodOfTime = periodOfTime;
        this.cityName = cityName;
        this.attractions = new ArrayList<>();
    }
    public void addAttraction(Object attraction) {
        attractions.add(attraction);
    }
    @Override
    public String toString() {
        return "Trip{" +
                "periodOfTime='" + periodOfTime + '\'' +
                ", cityName='" + cityName + '\'' +
                ", attractions=" + attractions +
                '}';
    }

    public List<Object> visitable(){
        List<Object> visitableNotPayable = attractions.stream()
                .filter(attraction -> attraction instanceof Visitable && !(attraction instanceof Payable))
                .sorted(Comparator.comparing(attraction -> ((Visitable) attraction).getOpeningHours()))
                .collect(Collectors.toList());
        return visitableNotPayable;
    }

}
