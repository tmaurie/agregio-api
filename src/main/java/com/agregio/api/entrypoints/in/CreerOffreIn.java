package com.agregio.api.entrypoints.in;

import com.agregio.api.core.Marche;
import com.agregio.api.core.model.BlocHoraire;

import java.util.List;

public record CreerOffreIn(String nom, Marche marche, List<BlocHoraire> blocsHoraires) {
}

