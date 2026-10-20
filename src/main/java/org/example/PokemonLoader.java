package org.example;

import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.type.CollectionType;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PokemonLoader {

    public List<Pokemon> cargarDesdeJson(String nombreArchivo) throws IOException {
        JsonMapper mapper = JsonMapper.builder().build();

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(nombreArchivo)) {
            if (inputStream == null) {
                throw new IOException("No se pudo encontrar el archivo en resources: " + nombreArchivo);
            }

            CollectionType listType = mapper.getTypeFactory().constructCollectionType(List.class, Pokemon.class);
            return mapper.readValue(inputStream, listType);
        }
    }
}