package com.agregio.api.core.exceptions;

public class ParcNotFoundException extends RuntimeException{
    public ParcNotFoundException(String message) {
        super(message);
    }
}
