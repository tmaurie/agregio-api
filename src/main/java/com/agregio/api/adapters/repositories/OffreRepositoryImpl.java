package com.agregio.api.adapters.repositories;

import com.agregio.api.core.Marche;
import com.agregio.api.core.model.Offre;
import com.agregio.api.core.ports.OffreRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OffreRepositoryImpl implements OffreRepository {

    List<Offre> offres;

    @Override
    public void creerOffre(Offre offre) {
        offres.add(offre);
    }

    @Override
    public List<Offre> listeOffreParMarche(Marche marche) {
        return offres.stream()
                .filter(offre -> offre.marche().equals(marche))
                .toList();
    }
}
