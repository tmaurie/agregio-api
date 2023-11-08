package com.agregio.api.adapters.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class BlocHoraireEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int heureDebut;
    private int heureFin;
    private double quantiteEnergieMW;
    private double prixPlancher;

    @ManyToOne
    private OffreEntity offre;

    @ManyToMany
    @JoinTable(
            name = "bloc_parc",
            joinColumns = @JoinColumn(name = "bloc_horaire_id"),
            inverseJoinColumns = @JoinColumn(name = "parc_id")
    )
    private List<ParcEntity> parcs;


    public BlocHoraireEntity() {
    }

    public BlocHoraireEntity(int heureDebut, int heureFin, double quantiteEnergieMW, double prixPlancher, OffreEntity offre, List<ParcEntity> parcs) {
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.quantiteEnergieMW = quantiteEnergieMW;
        this.prixPlancher = prixPlancher;
        this.offre = offre;
        this.parcs = parcs;
    }

}