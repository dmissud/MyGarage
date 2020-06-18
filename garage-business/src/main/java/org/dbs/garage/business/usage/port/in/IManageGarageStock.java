package org.dbs.garage.business.usage.port.in;

import org.dbs.garage.business.usage.port.out.ExUnknowGarage;
import org.dbs.garage.business.usage.port.out.ExUnknowLocation;
import org.dbs.garage.business.usage.port.out.ExUnknowGarage;
import org.dbs.garage.business.usage.port.out.ExUnknowLocation;

import java.util.List;

public interface IManageGarageStock {
    void registerVehicleToGarage(List<RegisterVehicleCmd> lstVehicleToRegister);
    void registerGarage(RegisterGarageCmd aNewGarageCmd) throws ExUnknowLocation, ExUnknowLocation;
    void unRegisterGarage(UnregisterGarageCmd unregisterGarageCmd) throws ExUnknowGarage, ExGarageGotVehicles, ExUnknowGarage;
}
