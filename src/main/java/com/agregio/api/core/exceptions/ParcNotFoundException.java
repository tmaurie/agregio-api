package com.agregio.api.core.exceptions;

public class ParcNotFoundException extends RuntimeException{
    public ParcNotFoundException(String message) {
        super("Aucun parc trouvé pour le marché " + message);
    }
}
