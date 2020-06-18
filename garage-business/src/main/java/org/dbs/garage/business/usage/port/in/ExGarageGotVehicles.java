package org.dbs.garage.business.usage.port.in;

public class ExGarageGotVehicles extends Exception {
    public ExGarageGotVehicles(String garageName, int numberOfVehicule) {
        super(String.format("%s have %d", garageName, numberOfVehicule));
    }
}
