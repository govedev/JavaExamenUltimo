package com.ej2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

  public static void main(String[] args) throws StreamReadException, DatabindException, IOException {

    ObjectMapper mapper = new ObjectMapper();

    File añañin = new File("proyectos.json");

    File añañin2 = new File("proyectos_largo_maria.json");

    List<Proyecto> lista = mapper.readValue(new File("proyectos.json"), new TypeReference<List<Proyecto>>() {});

    List<Proyecto> proyectosSeleccionados = new ArrayList<>();

    try {

      for (Proyecto persona : lista) {

        if (persona.getLíder().equals("Juan")) {

          persona.setLíder("Alberto");
          mapper.writeValue(añañin, lista);

        }

        String lider = persona.getLíder();

        if (lider.equalsIgnoreCase("Maria") && persona.getDuración() >= 12) {

          proyectosSeleccionados.add(persona);
          mapper.writeValue(añañin2, proyectosSeleccionados);

        }

      }
      

    } catch (StreamReadException e) {

    }

  }

}
