package org.dbs.garage.business.usage.port.out;

public class AdapterException extends RuntimeException {
    public AdapterException() {
        super("La configuration de l'infrastructure n'est pas valide");
    }

    public AdapterException(String message) {
        super(message);
    }
}
