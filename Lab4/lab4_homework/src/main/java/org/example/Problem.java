package org.example;

import com.github.javafaker.Faker;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem {
    private List<Driver> drivers;
    private List<Passenger> passengers;
    private List<String> destinations;
    public int numDestinations;

    public Problem(int numDrivers, int numPassengers, int numDestinations) {
        this.drivers = generateDrivers(numDrivers);
        this.passengers = generatePassengers(numPassengers);
        this.destinations = generateDestinations(numDestinations);
        this.numDestinations = numDestinations;
    }

    private List<String> generateDestinations(int numDestinations) {
        Faker faker = new Faker();
        List<String> destinations = new ArrayList<>();
        for (int i = 0; i < numDestinations; i++) {
            destinations.add(faker.address().city());
        }
        return destinations;
    }

    private List<Driver> generateDrivers(int numDrivers) {
        Faker faker = new Faker();
        Random random = new Random();
        List<Driver> drivers = new ArrayList<>();
        for (int i = 1; i < numDrivers; i++) {
            drivers.add(new Driver(faker.number().numberBetween(20, 70),
                    faker.name().fullName(),
                    i, false));
        }
        return drivers;
    }

    private List<Passenger> generatePassengers(int numPassengers) {
        Faker faker = new Faker();
        Random random = new Random();
        List<Passenger> passengers = new ArrayList<>();
        for (int i = 1; i < numPassengers; i++) {
            passengers.add(new Passenger(faker.number().numberBetween(20, 70),
                    faker.name().fullName(),
                    i));
        }
        return passengers;
    }

    public List<String> destinationsList() {
        return drivers.stream()
                .map(driver -> destinations.get(driver.getDestination() - 1))
                .distinct()
                .collect(Collectors.toList());
    }


    public Map<String, List<Person>> getDestinationsMap() {
        Map<String, List<Person>> destinationsPeopleMap = new HashMap<>();

        drivers.forEach(driver -> destinationsPeopleMap
                .computeIfAbsent(destinations.get(driver.getDestination() ), k -> new ArrayList<>())
                .add(driver));

        passengers.forEach(passenger -> destinationsPeopleMap
                .computeIfAbsent(destinations.get(passenger.getDestination() ), k -> new ArrayList<>())
                .add(passenger));

        return destinationsPeopleMap;
    }


    public void matchDriversAndPassengers() {
        for (Driver driver : drivers) {
            for (Passenger passenger : passengers) {
                if (driver.getDestination() == passenger.getDestination()) {
                    driver.setHasPassenger(true);
                    passengers.remove(passenger);
                    break;
                }
            }
        }
    }
}
