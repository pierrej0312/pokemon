package com.pixelmon.controller;

import com.pixelmon.model.Pokemon;
import com.pixelmon.repository.PokemonRepository;
import com.pixelmon.service.PokemonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonRepository repository;
    private final PokemonService service;

    public PokemonController(PokemonRepository repository, PokemonService service) {
        this.repository = repository;
        this.service = service;
    }

    // récupérer tous les Pokémon depuis la DB
    @GetMapping
    public List<Pokemon> getAll() {
        return repository.findAll();
    }

    // récupérer un Pokémon via PokéAPI (cache côté backend)
    @GetMapping("/{id}")
    public String getPokemon(@PathVariable int id) {
        return service.getPokemon(id);
    }

    // créer un Pokémon en DB
    @PostMapping
    public Pokemon create(@RequestBody Pokemon p) {
        return repository.save(p);
    }
}