package com.agregio.api.inmemory;

import com.agregio.api.core.Marche;
import com.agregio.api.core.model.Offre;
import com.agregio.api.core.ports.OffreRepository;

import java.util.List;
import java.util.Map;

public class InMemoryOffreRepository implements OffreRepository {

    private final Map<String, Offre> dataSource;

    public InMemoryOffreRepository(Map<String, Offre> dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void creerOffre(Offre offre) {
        dataSource.put(offre.nom(), offre);
    }

    @Override
    public List<Offre> listeOffreParMarche(Marche marche) {
        return dataSource.values().stream()
                .filter(o -> o.marche().equals(marche))
                .toList();
    }


}
