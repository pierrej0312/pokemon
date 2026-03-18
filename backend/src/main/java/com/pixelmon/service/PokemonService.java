package com.pixelmon.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PokemonService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final Map<Integer, String> cache = new HashMap<>();

    public String getPokemon(int id) {
        if (cache.containsKey(id)) return cache.get(id);

        try {
            String url = "https://pokeapi.co/api/v2/pokemon/" + id;
            String data = restTemplate.getForObject(url, String.class);
            cache.put(id, data);
            return data;
        } catch (Exception e) {
            return "{}"; // fallback
        }
    }
}