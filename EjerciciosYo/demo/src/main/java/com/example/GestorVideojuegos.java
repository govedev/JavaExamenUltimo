package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorVideojuegos {

  Map<String, List<Videojuego>> videojuegosPorGenero = new HashMap<>();  

  File archivo = new File("videojuegos.dat");


  public void añadirVideojuegos(Videojuego videojuego){

    String genero = videojuego.getGenero();

    if (!videojuegosPorGenero.containsKey(genero)) {
    
      videojuegosPorGenero.put(genero, new ArrayList<>());

    }
    videojuegosPorGenero.get(genero).add(videojuego);

  }

  public void mostrarVideojuegosPorGenero(String genero){


    for (Videojuego video : videojuegosPorGenero.get(genero)){

      System.out.println(video.toString());

    }
  }

  public void prestrarVideojuego(String id){

    for (Map.Entry<String, List<Videojuego>> entrada : videojuegosPorGenero.entrySet()) {
      List<Videojuego> lista = entrada.getValue();

      for (Videojuego videojuego : lista) {
        if (id.equals(videojuego.getId())) {

          videojuego.setDisponible(false);
        }
        
      }

    }

  }

  public void devolverVideojuego(String id){

    for (Map.Entry<String, List<Videojuego>> entrada : videojuegosPorGenero.entrySet()) {
      List<Videojuego> lista = entrada.getValue();

      for (Videojuego videojuego : lista) {
        if (id.equals(videojuego.getId())) {

          videojuego.setDisponible(true);
        }
        
      }

      
    }
  }







  @SuppressWarnings("unchecked")
  public void cargarDatos(){

    File archivo = new File("videojuegos.dat");

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
      videojuegosPorGenero = (Map<String, List<Videojuego>>) ois.readObject(); // Necesita Casting

    } catch (FileNotFoundException e){
      System.out.println("El archivo no fue encontrado");

    } catch (IOException e){
      System.out.println("Error de entrada/salida");

    } catch (ClassNotFoundException e){
      System.out.println("Error de clase");
    }

  }

  public void guardarDatos(){

    File archivo = new File("videojuegos.dat");

    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
      oos.writeObject(videojuegosPorGenero); // Puede ser un ArrayLi cst entero
    } catch (FileNotFoundException e){
      System.out.println("El archivo no fue encontrado");
    } catch (IOException e){
      System.out.println("Error de entrada/salida");
    }

  }
}