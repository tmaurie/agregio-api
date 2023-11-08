package com.agregio.api.adapters.repositories;

import com.agregio.api.core.Marche;
import com.agregio.api.core.model.Offre;
import com.agregio.api.core.model.Parc;
import com.agregio.api.core.ports.OffreRepository;
import com.agregio.api.core.ports.ParcRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParcRepositoryImpl implements ParcRepository {

    OffreRepository offreRepository;
    List<Parc> parcs;

    public ParcRepositoryImpl(OffreRepository offreRepository) {
        this.offreRepository = offreRepository;
    }

    @Override
    public void creerParc(Parc parc) {
        parcs.add(parc);
    }

    @Override
    public List<Parc> listeParcParMarche(Marche marche) {
        List<Offre> offres = offreRepository.listeOffreParMarche(marche);
        return parcs.stream()
                .filter(parc -> offres.stream()
                .anyMatch(offre -> offre.parcs().contains(parc)))
                .toList();
    }
}
