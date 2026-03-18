package com.pixelmon.controller;

import com.pixelmon.model.Player;
import com.pixelmon.repository.PlayerRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private final PlayerRepository repository;

    public PlayerController(PlayerRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Player create(@RequestBody Player player) {
        return repository.save(player);
    }

    @GetMapping("/{id}")
    public Player get(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }
}