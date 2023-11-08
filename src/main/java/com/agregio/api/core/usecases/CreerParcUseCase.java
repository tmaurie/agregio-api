package com.agregio.api.core.usecases;

import com.agregio.api.core.model.Parc;
import com.agregio.api.core.ports.ParcRepository;
import com.agregio.api.entrypoints.in.CreerParcIn;

import java.util.UUID;

public class CreerParcUseCase {

    private final ParcRepository parcRepository;

    public CreerParcUseCase(ParcRepository parcRepository) {
        this.parcRepository = parcRepository;
    }

    public void execute(CreerParcIn creerParcIn) {
        UUID uuid = UUID.randomUUID();
        Parc parc = new Parc(uuid, creerParcIn.nom(), creerParcIn.typeParc(), creerParcIn.capaciteMW());
        parcRepository.creerParc(parc);
    }
}
