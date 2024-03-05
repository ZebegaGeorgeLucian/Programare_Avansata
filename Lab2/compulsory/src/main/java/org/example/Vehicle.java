package org.example;

import java.util.Arrays;

public class Vehicle {
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

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId + " belongs to the depot with the ID =" +vehicleDepot +
                '}' ;
    }
}
