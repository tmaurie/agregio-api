package com.agregio.api.core.usecases;

import com.agregio.api.core.Marche;
import com.agregio.api.core.model.Parc;
import com.agregio.api.core.ports.ParcRepository;

import java.util.List;

public class ListerParcsUseCase {

    private final ParcRepository parcRepository;

    public ListerParcsUseCase(ParcRepository parcRepository) {
        this.parcRepository = parcRepository;
    }

    public List<Parc> execute(Marche marche) {
        return parcRepository.listeParcParMarche(marche);
    }
}

