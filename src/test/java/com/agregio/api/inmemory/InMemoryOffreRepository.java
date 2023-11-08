package com.agregio.api.inmemory;

import com.agregio.api.core.Marche;
import com.agregio.api.core.model.Offre;
import com.agregio.api.core.ports.OffreRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class InMemoryOffreRepository implements OffreRepository {

    private final Map<String, Object> dataSource;

    public InMemoryOffreRepository(Map<String, Object> dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void creerOffre(Offre offre) {
        dataSource.put(offre.getNom(), offre);
    }

    @Override
    public List<Offre> listeOffreParMarche(Marche marche) {
        return dataSource.values().stream()
                .filter(o -> ((Offre) o).getMarche().equals(marche))
                .map(o -> (Offre) o)
                .toList();
    }


}
