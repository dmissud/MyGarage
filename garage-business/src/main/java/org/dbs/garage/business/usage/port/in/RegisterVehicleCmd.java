package org.dbs.garage.business.usage.port.in;

import org.dbs.garage.business.domain.Marque;

public class RegisterVehicleCmd {
    private final String nameOfGarage;
    private final String idChassis;
    private final Marque marque;

    public RegisterVehicleCmd(String nameOfGarage, String idChassis, Marque marque) {
        this.nameOfGarage = nameOfGarage;
        this.idChassis = idChassis;
        this.marque = marque;
    }

    public String getNameOfGarage() {
        return nameOfGarage;
    }

    public String getIdChassis() {
        return idChassis;
    }

    public Marque getMarque() {
        return marque;
    }

}
