package com.ej3;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EventoGestor {

  Map<String, Evento> eventosMap = new HashMap<>();

  ObjectMapper mapper = new ObjectMapper();

  File arcihvo = new File("eventos.json");

  public void leerEventos() throws IOException {

    try {
      eventosMap = mapper.readValue(arcihvo, new TypeReference<Map<String, Evento>>() {
      });
    } catch (IOException e) {
      // TODO: handle exception
    }

  }

  public void cargarEventos() {

    try {
      mapper.writeValue(arcihvo, eventosMap);
    } catch (StreamWriteException e) {
      // TODO: handle exception
    } catch (DatabindException e) {

    } catch (IOException e) {

    }

  }

  public void añadirEventos(Evento evento) {

    eventosMap.put(evento.getId(), evento);

    cargarEventos();

  }

  public void listarEventosExistentes() {

    for (Map.Entry<String, Evento> entrada : eventosMap.entrySet()) {
      System.out.println(entrada.getValue().toString());

    }

  }

  public void eliminarEventos(String id) {

    Iterator<Map.Entry<String, Evento>> it = eventosMap.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry<String, Evento> entrada = it.next();

      if (entrada.getKey().equals(id)) {
        it.remove();
      }
    }

    cargarEventos();

  }

}
