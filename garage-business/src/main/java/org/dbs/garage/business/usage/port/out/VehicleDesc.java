package org.dbs.garage.business.usage.port.out;

import org.dbs.garage.business.domain.Marque;

public class VehicleDesc {
    private final String idChassis;
    private final Marque marque;

    public VehicleDesc(String idChassis, Marque marque) {
        this.idChassis = idChassis;
        this.marque = marque;
    }

    public String getIdChassis() {
        return idChassis;
    }

    public Marque getMarque() {
        return marque;
    }
}
