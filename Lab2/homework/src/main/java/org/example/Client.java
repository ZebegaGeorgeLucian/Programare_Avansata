package org.example;

import java.util.Objects;

public class Client {
    ClientType type;
    public String name;
    public int startTime;
    public int endTime;
    public int clientId;

    public Client(String name , int startTime , int endTime , ClientType type, int clientId) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
    }

    public ClientType getType() {
        return type;
    }

    public void setType(ClientType type) {
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

    public int getStartTime() {
        return startTime;
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
    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(!(o instanceof Client))
            return false;
        Client client = (Client) o;
        return  Objects.equals(clientId, client.clientId);
    }
}
