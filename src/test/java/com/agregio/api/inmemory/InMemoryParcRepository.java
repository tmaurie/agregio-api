package com.agregio.api.inmemory;

import com.agregio.api.core.Marche;
import com.agregio.api.core.model.Offre;
import com.agregio.api.core.model.Parc;
import com.agregio.api.core.ports.OffreRepository;
import com.agregio.api.core.ports.ParcRepository;

import java.util.List;
import java.util.Map;

public class InMemoryParcRepository implements ParcRepository {

    private final OffreRepository offreRepository;
    private final Map<String, Parc> dataSource;

    public InMemoryParcRepository(Map<String, Parc> dataSource, OffreRepository offreRepository) {
        this.dataSource = dataSource;
        this.offreRepository = offreRepository;
    }

    @Override
    public void creerParc(Parc parc) {
        dataSource.put(parc.nom(), parc);
    }

    @Override
    public List<Parc> listeParcParMarche(Marche marche) {
        List<Offre> offres = offreRepository.listeOffreParMarche(marche);
        return offres.stream()
                .map(Offre::parcs)
                .flatMap(List::stream)
                .toList();
    }

}
