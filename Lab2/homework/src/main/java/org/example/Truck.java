package org.example;

public class Truck extends Vehicle {
    private final int capacity;
    public Truck (int vehicleId, int vehicleDepot ,int capacity){
        super(vehicleId, vehicleDepot);
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "capacity=" + capacity +
                " vehicleID = " + vehicleId + " vehicleDepot = " + vehicleDepot +" }";
    }
}
