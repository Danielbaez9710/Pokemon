package com.example.pokemon.persistence.repository;

import com.example.pokemon.persistence.entity.PokemonEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface PokemonRepository extends ListCrudRepository<PokemonEntity, Integer> {
    List<PokemonEntity> findAllByEvolucionableTrueOrderByIdPokemon();
    List<PokemonEntity> findAllByTipoPrimarioContainingIgnoreCaseOrTipoSecundarioContainingIgnoreCaseOrderByIdPokemon(String tipo1 ,String tipo2);
    List<PokemonEntity> findByNombreContainingIgnoreCaseOrderByIdPokemon(String nombre);
}
