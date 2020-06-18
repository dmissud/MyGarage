package org.dbs.garage.business.usage.port.out;

import org.dbs.garage.business.domain.Garage;

import java.util.List;

public interface IRepositoryOfGarage {
    Garage retrieveGarageByName(String garageName) throws ExUnknowGarage;
    List<String> retrieveNameOfGarageByLocation(String locationName);
    List<String> retrieveNameOfAllGarage();
    void store(Garage garage);
    void delete(Garage garage) throws ExUnknowGarage;
}
