package org.dbs.garage.business.usage.port.out;

import org.dbs.garage.business.domain.Location;

import java.util.List;

public interface IRepositoryOfLocation {
    Location retrieveLocationByName(String locationName) throws ExUnknowLocation;
    void store(Location location);
    void delete(Location location) throws ExUnknowLocation;
    List<Location> retrieveAllLocation();
}
