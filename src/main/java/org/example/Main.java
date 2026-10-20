package org.example;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String archivoJson = "pokemon.json";
        String rutaInforme = "informe_pokemon.txt";

        try {
            PokemonLoader loader = new PokemonLoader();
            List<Pokemon> pokemons = loader.cargarDesdeJson(archivoJson);

            PokemonAnalyzer analyzer = new PokemonAnalyzer(pokemons);

            ReportGenerator generator = new ReportGenerator();
            generator.generarInforme(analyzer, rutaInforme);

            System.out.println("¡Informe generado con éxito en " + rutaInforme + "!");
        } catch (Exception e) {
            System.err.println("Error durante la ejecución: " + e.getMessage());
            e.printStackTrace();
        }
    }
}