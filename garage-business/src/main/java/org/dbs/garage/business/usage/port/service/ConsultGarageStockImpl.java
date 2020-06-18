package org.dbs.garage.business.usage.port.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dbs.garage.business.domain.Garage;
import org.dbs.garage.business.domain.Vehicle;
import org.dbs.garage.business.usage.port.out.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ConsultGarageStockImpl implements IConsultGarageStock {

    @Autowired
    private final IRepositoryOfGarage repositoryOfGarage;

    @Override
    public List<GarageDesc> retrieveSupervisionOfGarage() {
        List<GarageDesc> lstDescOfGarage = new ArrayList<>();
        try {
            List<String> lstNameOfGarage = repositoryOfGarage.retrieveNameOfAllGarage();
            for (String nameOfGarage : lstNameOfGarage) {
                Garage aGarage = repositoryOfGarage.retrieveGarageByName(nameOfGarage);
                GarageDesc garageDescription =
                        new GarageDesc(
                                nameOfGarage,
                                aGarage.getLocationName(),
                                aGarage.giveNumberOfVehicule());
                lstDescOfGarage.add(garageDescription);
            }
        } catch (ExUnknowGarage exUnknowGarage) {
            log.error("ConsultGarageStockImpl::retrieveSupervisionOfGarage Ko "+exUnknowGarage.getMessage());
        }

        log.debug("ConsultGarageStockImpl::retrieveSupervisionOfGarage oK");
        return lstDescOfGarage;
    }

    @Override
    public List<GarageDesc> retrieveGarageWithLowStock(int minimalStock) {
        List<GarageDesc> lstDescOfGarage = new ArrayList<>();
        try {
            List<String> lstNameOfGarage = repositoryOfGarage.retrieveNameOfAllGarage();
            for (String nameOfGarage : lstNameOfGarage) {
                Garage aGarage = repositoryOfGarage.retrieveGarageByName(nameOfGarage);
                GarageDesc garageDescription =
                        new GarageDesc(
                                nameOfGarage,
                                aGarage.getLocationName(),
                                aGarage.giveNumberOfVehicule());
                if (aGarage.giveNumberOfVehicule() <= minimalStock) {
                    lstDescOfGarage.add(garageDescription);
                }
            }

        } catch (ExUnknowGarage exUnknowGarage) {
            log.error(exUnknowGarage.getMessage());
        }

        log.debug("ConsultGarageStockImpl::retrieveGarageWithLowStock oK");
        return lstDescOfGarage;
    }

    @Override
    public GarageStockDesc retrieveGarageStockByName(String nameOfGarage) throws ExUnknowGarage {
        Garage aGarage = repositoryOfGarage.retrieveGarageByName(nameOfGarage);
        GarageStockDesc garageStockDesc =
                new GarageStockDesc(new GarageDesc(aGarage.getName(),
                        aGarage.getLocationName(),
                        aGarage.giveNumberOfVehicule()));
        Map<String, Vehicle> lstVehicles = aGarage.giveLstVehicleInGarage();
        for (Vehicle vehicle: lstVehicles.values()) {
            garageStockDesc.addVehicleDesc(new VehicleDesc(vehicle.identification(), vehicle.getMarque()));
        }
        log.debug("ConsultGarageStockImpl::retrieveGarageStockByName oK");
        return garageStockDesc;
    }
}
