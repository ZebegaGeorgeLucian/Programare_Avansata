package org.example;

import java.util.Arrays;
import java.util.Objects;

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
    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(!(o instanceof Depot ))
            return false;
        Depot depot = (Depot) o;
        return Objects.equals(depotId , depot.depotId);
    }
}
