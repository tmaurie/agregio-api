package com.agregio.api.core;

public enum TypeParc {
    SOLAIRE,
    EOLIEN,
    HYDRAULIQUE;

    public static TypeParc getValue(String typeParc) {
        return valueOf(typeParc);
    }
}
