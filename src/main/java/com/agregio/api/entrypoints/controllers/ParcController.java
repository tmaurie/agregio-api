package com.agregio.api.entrypoints.controllers;

import com.agregio.api.core.Marche;
import com.agregio.api.core.model.Parc;
import com.agregio.api.core.usecases.CreerParcUseCase;
import com.agregio.api.core.usecases.ListerParcsUseCase;
import com.agregio.api.entrypoints.in.CreerParcIn;
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
@RequestMapping("/api/parcs")
public class ParcController {

    private final CreerParcUseCase creerParcUseCase;

    private final ListerParcsUseCase listerParcsUseCase;

    public ParcController(CreerParcUseCase creerParcUseCase, ListerParcsUseCase listerParcsUseCase) {
        this.creerParcUseCase = creerParcUseCase;
        this.listerParcsUseCase = listerParcsUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> creerParc(@RequestBody CreerParcIn parcIn) {
        creerParcUseCase.execute(parcIn);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{marche}")
    public List<Parc> listerParcsPourMarche(@PathVariable Marche marche) {
        try {
            return listerParcsUseCase.execute(marche);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
