package org.dbs.garage.business.domain;


public class ExceptionVehicleReference extends Exception {
    public ExceptionVehicleReference(String identification) {
        super("ExceptionVehicleReference " + identification);
    }
}
