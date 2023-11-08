package com.agregio.api.core.exceptions;

public class OfferNotFoundException extends RuntimeException {
    public OfferNotFoundException(String message) {
        super("Aucune offre trouvée pour le marché " + message);
    }
}
