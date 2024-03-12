package org.example;

public class Statue implements Visitable  {
    String openDays;
    String openingHours;
    String name;
    String description;
    String image;

    Statue(String name, String description, String image, String openDays, String openingHours) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.openDays = openDays;
        this.openingHours = openingHours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String getOpenDays() {
        return openDays;
    }

    @Override
    public String getOpeningHours() {
        return openingHours;
    }
    @Override
    public String toString() {
        return "Statue{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", image='" + getImage() + '\'' +
                ", openDays='" + openDays + '\'' +
                ", openingHours='" + openingHours + '\'' +
                '}';
    }


}
