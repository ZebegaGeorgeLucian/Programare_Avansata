package org.example;

public class Driver extends Person{

    boolean hasPassenger;
    public Driver(int age, String name, int destination ,boolean hasPassenger) {
        super(age, name, destination);
        this.hasPassenger = hasPassenger;
    }

}
