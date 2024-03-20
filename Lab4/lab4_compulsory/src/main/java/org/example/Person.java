package org.example;

public class Person {
    private int age;
    private String name;
    private int destination;

    public Person(int age, String name,int destination) {
        this.age = age;
        this.name = name;
        this.destination = destination;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
