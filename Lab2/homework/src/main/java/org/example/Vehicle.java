package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class Vehicle {
    public int vehicleId;
    public int vehicleDepot;
    public int getVehicleDepot() {
        return vehicleDepot;
    }

    public void setVehicleDepot(int vehicleDepot) {
        this.vehicleDepot = vehicleDepot;
    }

    public Vehicle(int vehicleId , int vehicleDepot) {
        this.vehicleId = vehicleId;
        this.vehicleDepot = vehicleDepot;
    }

    public int getVehicleId() {
        return vehicleId;
    }


    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

//    @Override
//    public String toString() {
//        return "Vehicle{" +
//                "vehicleId=" + vehicleId + " belongs to the depot with the ID =" +vehicleDepot +
//                '}' ;
//    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(!(o instanceof Vehicle))
            return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(vehicleId, vehicle.vehicleId);
    }
}