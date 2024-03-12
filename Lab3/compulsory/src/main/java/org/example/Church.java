package org.example;

public class Church {
    String name;
    String description;
    String image;

    Church(String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Church{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", image='" + getImage() + '\''+
                '}';
    }
}
