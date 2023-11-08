package com.agregio.api.adapters.entities;

import com.agregio.api.core.Marche;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class OffreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;


    private Marche marche;

    @OneToMany(mappedBy = "offre")
    private List<BlocHoraireEntity> blocsHoraires;

    @OneToMany
    private List<ParcEntity> parcs;

    public OffreEntity() {
    }

    public OffreEntity(String nom, Marche marche, List<BlocHoraireEntity> blocsHoraires, List<ParcEntity> parcs) {
        this.nom = nom;
        this.marche = marche;
        this.blocsHoraires = blocsHoraires;
        this.parcs = parcs;
    }


}

