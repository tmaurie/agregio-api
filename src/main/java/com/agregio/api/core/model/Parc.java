package com.agregio.api.core.model;

import com.agregio.api.core.TypeParc;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;
@Data
@AllArgsConstructor
public class Parc {

    private UUID id;
    private String nom;
    private TypeParc typeParc;
    private double capaciteMW;

}
