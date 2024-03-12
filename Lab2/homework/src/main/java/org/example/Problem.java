package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Problem {
    private List<Truck> trucks = new ArrayList<>();
    private List<Drone> drones = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();
    private List<Depot> depots = new ArrayList<>();
    private int[][] travelTimes;

    public Problem() {
    }
    public void addTruck(Truck truck) {
        trucks.add(truck);
    }
    public void addDrone(Drone drone) {
        drones.add(drone);
    }
    public void addClient(Client client){
        clients.add(client);
    }
    public void addDepot(Depot depot){
        depots.add(depot);
    }
    public Vehicle[] getVehicles() {
        List<Vehicle> allVehicles = new ArrayList<>();
        allVehicles.addAll(trucks);
        allVehicles.addAll(drones);
        return allVehicles.toArray(new Vehicle[0]);
    }

    public void setTravelTimes(int[][] travelTimes) {
        this.travelTimes = travelTimes;
    }

    public void allocateClients() {
        for (Vehicle vehicle : getVehicles()) {
            List<Client> unallocatedClients = new ArrayList<>(clients);
            List<Client> allocatedClients = new ArrayList<>();


            // Allocate clients to the vehicle based on travel times
            while (!unallocatedClients.isEmpty()) {
                Client currentClient = unallocatedClients.remove(0);
                int currentIndex = clients.indexOf(currentClient);
                int minTravelTime = 100;
                Client bestClient = null;

                // Find the closest client
                for (Client candidate : unallocatedClients) {
                    int candidateIndex = clients.indexOf(candidate);
                    int travelTime = travelTimes[currentIndex][candidateIndex];

                    if (travelTime < minTravelTime) {
                        minTravelTime = travelTime;
                        bestClient = candidate;
                    }
                }

                if (bestClient != null) {
                    allocatedClients.add(currentClient);
                    allocatedClients.add(bestClient);
                    unallocatedClients.remove(bestClient);
                }
            }
        }
    }
}
