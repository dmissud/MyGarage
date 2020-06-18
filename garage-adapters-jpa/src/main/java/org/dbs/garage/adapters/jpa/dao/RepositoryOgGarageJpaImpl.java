package org.dbs.garage.adapters.jpa.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dbs.garage.business.domain.Garage;
import org.dbs.garage.business.usage.port.out.ExUnknowGarage;
import org.dbs.garage.business.usage.port.out.IRepositoryOfGarage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Repository
public class RepositoryOgGarageJpaImpl implements IRepositoryOfGarage {
    @Override
    public Garage retrieveGarageByName(String garageName) throws ExUnknowGarage {
        return null;
    }

    @Override
    public List<String> retrieveNameOfGarageByLocation(String locationName) {
        return null;
    }

    @Override
    public List<String> retrieveNameOfAllGarage() {
        return null;
    }

    @Override
    public void store(Garage garage) {

    }

    @Override
    public void delete(Garage garage) throws ExUnknowGarage {

    }
}
