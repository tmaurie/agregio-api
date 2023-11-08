package com.agregio.api.core.model;

public record BlocHoraire(Long id, int heureDebut, int heureFin, double quantiteEnergieMW, double prixPlancher) {
    public BlocHoraire {
        if (prixPlancher < 0) {
            throw new IllegalArgumentException("Le prix plancher ne peut pas être négatif.");
        }

        if (quantiteEnergieMW < 0) {
            throw new IllegalArgumentException("La quantité d'énergie ne peut pas être négative.");
        }
    }

}
