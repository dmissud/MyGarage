package org.dbs.garage.adapters.jpa.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dbs.garage.adapters.jpa.entities.TLocation;
import org.dbs.garage.business.domain.Location;
import org.dbs.garage.business.usage.port.out.ExUnknowLocation;
import org.dbs.garage.business.usage.port.out.IRepositoryOfLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class RepositoryOfLocationJpaImpl implements IRepositoryOfLocation {

    @Autowired
    private final IDaoTLocation daoTLocation;

    @Override
    public Location retrieveLocationByName(String locationName) throws ExUnknowLocation {
        return null;
    }

    @Override
    public void store(Location location) {

    }

    @Override
    public void delete(Location location) throws ExUnknowLocation {

    }

    @Override
    public List<Location> retrieveAllLocation() {
        List<TLocation> tLocations = daoTLocation.findAll();
        List<Location> locations = new ArrayList<>();
        for(TLocation tLocation:tLocations) {
            Location location = new Location(tLocation.getName(), tLocation.getAdress());
            locations.add(location);
        }
        log.debug("RepositoryOfLocationJpaImpl::retrieveAllLocation oK");
        return locations;
    }
}
