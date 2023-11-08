package com.agregio.api.core.model;

import com.agregio.api.core.TypeParc;

import java.util.UUID;

public record Parc(UUID id, String nom, TypeParc typeParc, double capaciteMW) {
}

