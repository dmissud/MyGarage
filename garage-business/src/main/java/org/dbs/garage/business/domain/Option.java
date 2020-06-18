package org.dbs.garage.business.domain;

public abstract class Option {

    abstract double getPrice();

    abstract String getName();

    abstract String getDescription();

    boolean isCompatible(Vehicle vehicle, Option option) {
        return true;
    }
}
