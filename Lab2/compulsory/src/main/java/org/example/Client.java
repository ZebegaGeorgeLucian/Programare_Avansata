package org.example;

public class Client {
    clientType type;
    public String name;
    public int startTime;
    public int endTime;

    public Client(String name , int startTime , int endTime , clientType type) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
    }

    public clientType getType() {
        return type;
    }

    public void setType(clientType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int time() {
        return endTime - startTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(int startTime , int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Client{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
