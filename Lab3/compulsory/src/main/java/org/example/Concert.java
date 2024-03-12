package org.example;

public class Concert implements Visitable, Payable{
    String openDays;
    String openingHours;
    int entryFee;
    String name;
    String description;
    String image;

    Concert(String name, String description, String image, String openDays, String openingHours, int entryFee) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.openDays = openDays;
        this.openingHours = openingHours;
        this.entryFee = entryFee;
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
    public double getEntryFee() {
        return entryFee;
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
        return "Concert{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", image='" + getImage() + '\'' +
                ", openDays='" + openDays + '\'' +
                ", openingHours='" + openingHours + '\'' +
                "entryFee= "+ entryFee +
                '}';
    }

}
