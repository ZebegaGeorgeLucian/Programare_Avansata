package org.example;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Problem problem = new Problem(3,3,3);
        System.out.println("Destinations for drivers: " + problem.destinationsList());
        System.out.println("Destinations and people: " + problem.getDestinationsMap());
        problem.matchDriversAndPassengers();
    }
}