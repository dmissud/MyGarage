package org.dbs.garage.business.usage.port.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dbs.garage.business.domain.Location;
import org.dbs.garage.business.usage.port.out.ExUnknowLocation;
import org.dbs.garage.business.usage.port.out.IConsultLocationStock;
import org.dbs.garage.business.usage.port.out.IRepositoryOfLocation;
import org.dbs.garage.business.usage.port.out.LocationDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class ConsultLocationStockImpl implements IConsultLocationStock {

    @Autowired
    private final IRepositoryOfLocation repositoryOfLocation;

    @Override
    public List<LocationDesc> retrieveSupervisionOfLocation() {
        List<LocationDesc> lstLocationDesc = new ArrayList<>();
        List<Location> lstOfLocation = this.repositoryOfLocation.retrieveAllLocation();
        for (Location location : lstOfLocation) {
            LocationDesc locationDescription = new LocationDesc(location.getName(), location.getAdress());
            lstLocationDesc.add(locationDescription);
        }

        log.debug("ConsultLocationStockImpl::retrieveSupervisionOfGarage");
        return lstLocationDesc;
    }
}
