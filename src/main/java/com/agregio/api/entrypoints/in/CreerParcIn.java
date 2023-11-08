package com.agregio.api.entrypoints.in;

import com.agregio.api.core.TypeParc;

public record CreerParcIn(String nom, TypeParc typeParc, int capaciteMW) {
}
