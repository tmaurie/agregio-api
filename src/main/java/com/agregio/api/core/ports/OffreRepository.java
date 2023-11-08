package com.agregio.api.core.ports;

import com.agregio.api.core.Marche;
import com.agregio.api.core.model.Offre;

import java.util.List;

public interface OffreRepository {

    void creerOffre(Offre offre);

    List<Offre> listeOffreParMarche(Marche marche);
}
