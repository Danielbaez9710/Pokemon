package com.example.pokemon.service;

import com.example.pokemon.persistence.entity.PokemonEntity;
import com.example.pokemon.persistence.repository.PokemonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<PokemonEntity> getAllPokemons() {
        return pokemonRepository.findAll();
    }
    public boolean exists(Integer id){
        return pokemonRepository.existsById(id);
    }
    public PokemonEntity getById(Integer id) {
        return pokemonRepository.findById(id).orElse(null);
    }

    public List<PokemonEntity> getAllPokemonsEvolucionables(){
        return pokemonRepository.findAllByEvolucionableTrueOrderByIdPokemon();
    }

    public List<PokemonEntity> getAllPokemonsByType(String tipo ){
        return pokemonRepository.findAllByTipoPrimarioContainingIgnoreCaseOrTipoSecundarioContainingIgnoreCaseOrderByIdPokemon(tipo, tipo);
    }

    public List<PokemonEntity> getAllPokemonsByName(String nombre ){
        return pokemonRepository.findByNombreContainingIgnoreCaseOrderByIdPokemon(nombre);
    }


}
