package com.example.pokemon.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="pokedex")
public class PokemonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @JsonIgnore
    private Integer id;

    @Column(name = "id_pokedex",nullable = false)
    private Integer idPokemon;

    @Column(nullable = false , unique = true)
    private String nombre;

    @Column(name = "tipo_primario", nullable = false )
    private String tipoPrimario;

    @Column(name = "tipo_secundario" )
    private String tipoSecundario;

    @Column(nullable = false , columnDefinition = "DECIMAL(5,2)")
    private Double peso;

    @Column(nullable = false , columnDefinition = "DECIMAL(5,2)")
    private Double altura;

    @Column(nullable = false , columnDefinition = "TINYINT")
    private Boolean evolucionable;

}
