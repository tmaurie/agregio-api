package com.agregio.api.adapters.entities;

import com.agregio.api.core.TypeParc;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ParcEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @Enumerated(EnumType.STRING)
    private TypeParc typeParc;

    private double capaciteMW;

    public ParcEntity() {
    }

    public ParcEntity(Long id, String nom, TypeParc typeParc, double capaciteMW) {
        this.id = id;
        this.nom = nom;
        this.typeParc = typeParc;
        this.capaciteMW = capaciteMW;
    }



}
