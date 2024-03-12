package org.example;

import java.util.ArrayList;
import java.util.List;

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

}
