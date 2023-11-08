package com.agregio.api.entrypoints.controllers;

import com.agregio.api.core.Marche;
import com.agregio.api.core.usecases.CreerParcUseCase;
import com.agregio.api.entrypoints.in.CreerParcIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/parcs")
public class ParcController {

    private final CreerParcUseCase creerParcUseCase;

    public ParcController(CreerParcUseCase creerParcUseCase) {
        this.creerParcUseCase = creerParcUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> creerParc(@RequestBody CreerParcIn parcIn) {
        creerParcUseCase.execute(parcIn);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{marche}")
    public String listerParcsPourMarche(@PathVariable Marche marche) {

        return "test";
    }
}
