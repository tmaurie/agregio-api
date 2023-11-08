package com.agregio.api.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BlocHoraire {

    private Long id;
    private int heureDebut;
    private int heureFin;
    private double quantiteEnergieMW;
    private double prixPlancher;
}
