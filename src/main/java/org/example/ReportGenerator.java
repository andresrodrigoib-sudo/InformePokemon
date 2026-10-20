package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ReportGenerator {

    public void generarInforme(PokemonAnalyzer analyzer, String rutaSalida) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaSalida))) {
            writer.write("=========================\n");
            writer.write(" INFORME DE POKÉMON\n");
            writer.write("=========================\n\n");

            writer.write("Total de Pokémon: " + analyzer.getTotalPokemon() + "\n\n");
            writer.write(String.format(Locale.US, "Nivel medio: %.2f\n\n", analyzer.getNivelMedio()));
            writer.write(String.format(Locale.US, "PS medios: %.2f\n\n", analyzer.getPsMedios()));

            Pokemon mayorNivel = analyzer.getPokemonMayorNivel();
            writer.write("Pokémon con mayor nivel:\n");
            if (mayorNivel != null) {
                writer.write(mayorNivel.getNombre() + " (Nivel " + mayorNivel.getNivel() + ")\n\n");
            } else {
                writer.write("N/A\n\n");
            }

            Pokemon masPs = analyzer.getPokemonMasPs();
            writer.write("Pokémon con más PS:\n");
            if (masPs != null) {
                writer.write(masPs.getNombre() + " (PS " + masPs.getPs() + ")\n\n");
            } else {
                writer.write("N/A\n\n");
            }

            writer.write("-------------------------\n");
            writer.write("POKÉMON POR TIPO\n");
            writer.write("-------------------------\n\n");

            Map<String, List<Pokemon>> porTipo = analyzer.agruparPorTipo();
            for (Map.Entry<String, List<Pokemon>> entry : porTipo.entrySet()) {
                String tipo = entry.getKey();
                List<Pokemon> lista = entry.getValue();

                writer.write(tipo + ": " + lista.size() + "\n");
                for (Pokemon p : lista) {
                    writer.write(p.getNombre() + "\n");
                }
                writer.write("\n");
            }
        }
    }
}