package com.agregio.api.core;

public enum Marche {
    PRIMAIRE,
    SECONDAIRE,
    RAPIDE;

    public static Marche getValue(String marche) {
        return valueOf(marche);
    }

}
