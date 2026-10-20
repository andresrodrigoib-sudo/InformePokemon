package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PokemonAnalyzer {

    private final List<Pokemon> pokemons;

    public PokemonAnalyzer(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public int getTotalPokemon() {
        return pokemons.size();
    }

    public double getNivelMedio() {
        return pokemons.stream()
                .mapToInt(Pokemon::getNivel)
                .average()
                .orElse(0.0);
    }

    public double getPsMedios() {
        return pokemons.stream()
                .mapToInt(Pokemon::getPs)
                .average()
                .orElse(0.0);
    }

    public Pokemon getPokemonMayorNivel() {
        return pokemons.stream()
                .max(Comparator.comparingInt(Pokemon::getNivel))
                .orElse(null);
    }

    public Pokemon getPokemonMasPs() {
        return pokemons.stream()
                .max(Comparator.comparingInt(Pokemon::getPs))
                .orElse(null);
    }

    public Map<String, List<Pokemon>> agruparPorTipo() {
        return pokemons.stream()
                .collect(Collectors.groupingBy(Pokemon::getTipo));
    }
}