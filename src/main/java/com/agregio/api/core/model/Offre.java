package com.agregio.api.core.model;

import com.agregio.api.core.Marche;

import java.util.List;
import java.util.UUID;



public record Offre(UUID id, String nom, Marche marche, List<BlocHoraire> blocsHoraires, List<Parc> parcs) {

}
