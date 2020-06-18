package org.dbs.garage.adapters.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dbs.garage.business.usage.port.out.IConsultLocationStock;
import org.dbs.garage.business.usage.port.out.LocationDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/Location")
public class ConsultLocationStockREST {

    @Autowired
    private final IConsultLocationStock consultLocationStock;

    @GetMapping("/All")
    public List<LocationDesc> retrieveAllNamesOfLocation() {
        return consultLocationStock.retrieveSupervisionOfLocation();
    }
}
