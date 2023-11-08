package com.agregio.api.core.usecases;

import com.agregio.api.core.model.Offre;
import com.agregio.api.core.ports.OffreRepository;
import com.agregio.api.entrypoints.in.CreerOffreIn;

import java.util.UUID;

public class CreerOffreUseCase {


    private final OffreRepository offreRepository;

    public CreerOffreUseCase(OffreRepository offreRepository) {
        this.offreRepository = offreRepository;
    }

    public void execute(CreerOffreIn creerOffreIn) {
        UUID uuid = UUID.randomUUID();
        Offre offre = new Offre(uuid, creerOffreIn.nom(), creerOffreIn.marche(), creerOffreIn.blocsHoraires(), null);
        offreRepository.creerOffre(offre);
    }
}
