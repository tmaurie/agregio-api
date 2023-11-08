package com.agregio.api.core.usecases;

import com.agregio.api.core.Marche;
import com.agregio.api.core.exceptions.OfferNotFoundException;
import com.agregio.api.core.model.Offre;
import com.agregio.api.core.ports.OffreRepository;

import java.util.List;

public class ListerOffresUseCase {

    private final OffreRepository offreRepository;

    public ListerOffresUseCase(OffreRepository offreRepository) {
        this.offreRepository = offreRepository;
    }

    public List<Offre> execute(Marche marche) {
        List<Offre> offres = offreRepository.listeOffreParMarche(marche);
        if (offres.isEmpty()) {
            throw new OfferNotFoundException(marche.name());
        }
        return offres;
    }
}
