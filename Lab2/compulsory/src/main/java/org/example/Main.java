package org.example;

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client("Florentin" , 12, 16 ,clientType.PREMIUM );
        Vehicle vehicle1 = new Vehicle(1 ,1);
        Depot depot1 = new Depot(1);

        System.out.println(client1.toString());
        System.out.println(vehicle1.toString());
        System.out.println(depot1.toString());
    }
}