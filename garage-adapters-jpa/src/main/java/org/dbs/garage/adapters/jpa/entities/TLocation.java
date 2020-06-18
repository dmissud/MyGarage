package org.dbs.garage.adapters.jpa.entities;


import org.dbs.garage.adapters.jpa.dao.IEntity;

import javax.persistence.*;

@Entity
public class TLocation implements IEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String adress;

    public TLocation() {
    }

    public TLocation(String name, String adress) {
        this.name = name;
        this.adress = adress;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

}
