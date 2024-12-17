package com.example.pokemon.web.controller;

import com.example.pokemon.persistence.entity.PokemonEntity;
import com.example.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pokedex")
public class PokemonController {
    private final PokemonService pokemonService;
    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public ResponseEntity<List<PokemonEntity>> getAllPokemons() {
        return ResponseEntity.ok(pokemonService.getAllPokemons());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<PokemonEntity> getById(@PathVariable Integer id) {

        if(this.pokemonService.exists(id)){
            return ResponseEntity.ok(pokemonService.getById(id));
        }
        return ResponseEntity.badRequest().build();

    }

    @GetMapping("/evolucionables")
    public ResponseEntity<List<PokemonEntity>> getPokemonsByEvolucionables(){
        return ResponseEntity.ok(pokemonService.getAllPokemonsEvolucionables());
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<PokemonEntity>> getAllPokemonsByType(@PathVariable String tipo){
        return ResponseEntity.ok(pokemonService.getAllPokemonsByType(tipo));
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<PokemonEntity>> getAllPokemonsByName(@PathVariable String nombre){
        return ResponseEntity.ok(pokemonService.getAllPokemonsByName(nombre));
    }
}
