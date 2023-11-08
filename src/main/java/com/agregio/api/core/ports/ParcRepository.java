package com.agregio.api.core.ports;

import com.agregio.api.core.Marche;
import com.agregio.api.core.model.Parc;

import java.util.List;

public interface ParcRepository {
    void creerParc(Parc parc);
    List<Parc> listeParcParMarche(Marche marche);
}
