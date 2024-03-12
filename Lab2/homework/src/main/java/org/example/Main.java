package org.example;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client("Client1", 8, 12, ClientType.REGULAR ,1);
        Client client2 = new Client("Client2", 10, 14, ClientType.PREMIUM, 2);
        Client client3 = new Client("Client3", 9, 13, ClientType.REGULAR, 3);

        Drone drone1 = new Drone(1 ,1, 4);
        Truck truck1 = new Truck(2,1,3);
        Depot depot1 = new Depot(1);

        Problem problem = new Problem();

        // Add depots, trucks, drones, and clients to the problem instance
        problem.addDepot(depot1);
        problem.addTruck(truck1);
        problem.addDrone(drone1);

        problem.addClient(client1);
        problem.addClient(client2);
        problem.addClient(client3);

        int[][] travelTimes = {
                {0, 3, 5}, // Depot to (Truck, Drone, Client1)
                {3, 0, 2}, // Truck to (Depot, Drone, Client2)
                {5, 2, 0}  // Drone to (Depot, Truck, Client3)
        };

        problem.setTravelTimes(travelTimes);
        problem.allocateClients();
    }
}