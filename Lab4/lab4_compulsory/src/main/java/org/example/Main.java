package org.example;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        List <Driver> drivers = new LinkedList<>();
//        Set<Passenger> passengers = new TreeSet<>();
        Stream<Person> personsStream = Stream.of(
                new Driver(21,"George",3,false),
                new Passenger(24,"Cristian",5),
                new Driver(30,"Alex",5,false),
                new Passenger(24,"Alexandra",5)
        );
        Stream<Person> personsStream2 = Stream.of(
                new Driver(21,"George",3,false),
                new Passenger(24,"Cristian",5),
                new Driver(30,"Alex",5,false),
                new Passenger(24,"Alexandra",5)
        );
        List<Driver> drivers = personsStream
                .filter(person -> person instanceof Driver)
                .map(person -> (Driver) person)
                .collect(Collectors.toCollection(LinkedList::new));

        TreeSet<Passenger> passengers = personsStream2
                .filter(person -> person instanceof Passenger)
                .map(person -> (Passenger) person)
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Passenger::getName))));


        drivers.stream()
                .sorted((driver1, driver2) -> Integer.compare(driver1.getAge(), driver2.getAge()))
                .forEach(driver -> System.out.println("Driver: " + driver.getName() + ", Age: " + driver.getAge()));

        passengers.stream()
                .forEach(passenger -> System.out.println("Passenger: " + passenger.getName() +
                  ", Age: " + passenger.getAge()));

    }
}