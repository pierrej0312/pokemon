package com.pixelmon;

import com.pixelmon.model.Player;
import com.pixelmon.model.Pokemon;
import com.pixelmon.repository.PlayerRepository;
import com.pixelmon.repository.PokemonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner testDatabase(PlayerRepository playerRepo, PokemonRepository pokemonRepo) {
        return args -> {
            Player p = new Player();
            p.setName("Ash");
            p.setPosX(0);
            p.setPosY(0);
            playerRepo.save(p);

            Pokemon poke = new Pokemon();
            poke.setApiId(25);
            poke.setName("Pikachu");
            poke.setLevel(5);
            pokemonRepo.save(poke);

            System.out.println("Tables created and entities saved!");
        };
    }
}