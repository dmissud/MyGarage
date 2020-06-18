package org.dbs.garage.adapters.jpa.dao;

import org.dbs.garage.adapters.jpa.entities.TLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface IDaoTLocation extends JpaRepository<TLocation, Long> {
}
