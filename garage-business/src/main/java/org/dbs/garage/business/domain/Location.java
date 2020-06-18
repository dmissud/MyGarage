package org.dbs.garage.business.domain;

public class Location implements Comparable<Location> {
    private final String name;
    private final String adress;

    public Location(String name, String adress) {
        this.name = name;
        this.adress = adress;
    }

    public Location(Location otherLocation) {
        this.name = otherLocation.getName();
        this.adress = otherLocation.getAdress();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return name.equals(location.name);
    }

    public String getName() {
        return this.name;
    }

    public String getAdress() {
        return adress;
    }

    public int compareTo(Location o) {
        return 0;
    }
}
