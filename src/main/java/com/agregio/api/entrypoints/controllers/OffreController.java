package com.agregio.api.entrypoints.controllers;

import com.agregio.api.core.Marche;
import com.agregio.api.core.model.Offre;
import com.agregio.api.core.usecases.CreerOffreUseCase;
import com.agregio.api.core.usecases.ListerOffresUseCase;
import com.agregio.api.entrypoints.in.CreerOffreIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/offres")
public class OffreController {

    private final CreerOffreUseCase creerOffreUseCase;
    private final ListerOffresUseCase listerOffresUseCase;

    public OffreController(CreerOffreUseCase creerOffreUseCase, ListerOffresUseCase listerOffresUseCase) {
        this.creerOffreUseCase = creerOffreUseCase;
        this.listerOffresUseCase = listerOffresUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> creerOffre(@RequestBody CreerOffreIn offreIn) {
        creerOffreUseCase.execute(offreIn);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{marche}")
    public List<Offre> listerOffresPourMarche(@PathVariable Marche marche) {
        try {
            return listerOffresUseCase.execute(marche);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
