package org.example;

import java.util.Arrays;

public class Depot {
    public int depotId;

    public Depot(int depotId) {
        this.depotId = depotId;
    }

    public int getDepotId() {
        return depotId;
    }

    public void setDepotId(int depotId) {
        this.depotId = depotId;
    }

    @Override
    public String toString() {
        return "Depot{" +
                "depotId=" + depotId +
                '}';
    }
}
