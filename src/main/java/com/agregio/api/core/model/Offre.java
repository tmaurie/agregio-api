package com.agregio.api.core.model;

import com.agregio.api.core.Marche;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;


@Data
@AllArgsConstructor
public class Offre {

    private UUID id;
    private String nom;
    private Marche marche;
    private List<BlocHoraire> blocsHoraires;
    private List<Parc> parcs;


}
