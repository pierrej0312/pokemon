package com.pixelmon.controller;

import com.pixelmon.model.Pokemon;
import com.pixelmon.repository.PokemonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonRepository repository;

    public PokemonController(PokemonRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Pokemon> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Pokemon create(@RequestBody Pokemon p) {
        return repository.save(p);
    }
}