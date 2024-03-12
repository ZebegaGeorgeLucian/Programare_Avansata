package org.example;

public class Drone extends Vehicle{
    private final int maxDurationFlight;
    public Drone(int vehicleId ,int vehicleDepot ,int maxDurationFlight){
        super(vehicleId,vehicleDepot);
        this.maxDurationFlight = maxDurationFlight;
    }

    @Override
    public String toString() {
        return "Drone{" +
                "vehicleId=" + vehicleId + " vehicleDepot = " + vehicleDepot +
                " maxDurationFlight = " + maxDurationFlight +
                '}';
    }
}
