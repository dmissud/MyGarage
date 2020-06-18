package org.dbs.garage.business.usage.port.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dbs.garage.business.domain.ExceptionVehicleReference;
import org.dbs.garage.business.domain.Garage;
import org.dbs.garage.business.domain.Location;
import org.dbs.garage.business.domain.Vehicle;
import org.dbs.garage.business.usage.port.in.*;
import org.dbs.garage.business.usage.port.out.ExUnknowGarage;
import org.dbs.garage.business.usage.port.out.ExUnknowLocation;
import org.dbs.garage.business.usage.port.out.IRepositoryOfGarage;
import org.dbs.garage.business.usage.port.out.IRepositoryOfLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ManageGarageStockImpl implements IManageGarageStock {

    @Autowired
    private final IRepositoryOfGarage repositoryOfGarage;

    @Autowired
    private final IRepositoryOfLocation repositoryOfLocation;

    @Override
    public void registerVehicleToGarage(List<RegisterVehicleCmd> lstVehicleToRegisterCmd) {
        for(RegisterVehicleCmd aVehicleToRegisterCmd: lstVehicleToRegisterCmd) {
            try {
                Garage garage = repositoryOfGarage.retrieveGarageByName(aVehicleToRegisterCmd.getNameOfGarage());
                garage.registerVehicle(new Vehicle(aVehicleToRegisterCmd.getIdChassis(),
                        aVehicleToRegisterCmd.getMarque()));
                repositoryOfGarage.store(garage);
                log.debug("ManageGarageStockImpl::registerVehicleToGarage ok");
            } catch (ExUnknowGarage | ExceptionVehicleReference ex) {
                log.error(ex.getMessage());
            }
        }
    }

    @Override
    public void registerGarage(RegisterGarageCmd aNewGarageCmd) throws ExUnknowLocation {
        Location location = repositoryOfLocation.retrieveLocationByName(aNewGarageCmd.getLocation());
        Garage garage = new Garage(aNewGarageCmd.getName(), location.getName());
        repositoryOfGarage.store(garage);
        log.debug("ManageGarageStockImpl::registerGarage ok");
    }

    @Override
    public void unRegisterGarage(UnregisterGarageCmd unregisterGarageCmd) throws ExUnknowGarage, ExGarageGotVehicles {
        Garage garage = repositoryOfGarage.retrieveGarageByName(unregisterGarageCmd.getName());
        if (garage.giveNumberOfVehicule() == 0) {
            repositoryOfGarage.delete(garage);
        } else {
            log.error("ManageGarageStockImpl::unRegisterGarage down");
            throw new ExGarageGotVehicles(garage.getName(), garage.giveNumberOfVehicule());
        }
        log.debug("ManageGarageStockImpl::unRegisterGarage ok");
    }
}
