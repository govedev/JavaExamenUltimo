package com.example;

import java.io.Serializable;


public class Videojuego implements Serializable {
  
    private static final long serialVersionUID = 1L;
    private String id;
    private String nombre;
    private String desarrollador;
    private String genero;
    private String plataforma;
    private boolean disponible;


    // Constructor completo para inicializar un videojuego
    public Videojuego(String id, String nombre, String desarrollador, String genero, String plataforma, boolean disponible) {
        this.id = id;
        this.nombre = nombre;
        this.desarrollador = desarrollador;
        this.genero = genero;
        this.plataforma = plataforma;
        this.disponible = disponible;
    }


    // Getters y setters para cada atributo
    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDesarrollador() {
        return desarrollador;
    }


    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }


    public String getGenero() {
        return genero;
    }


    public void setGenero(String genero) {
        this.genero = genero;
    }


    public String getPlataforma() {
        return plataforma;
    }


    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }


    public boolean isDisponible() {
        return disponible;
    }


    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }


    // Método toString para mostrar la información del videojuego de manera amigable
    @Override
    public String toString() {
        return "Videojuego{" +
                "ID='" + id + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Desarrollador='" + desarrollador + '\'' +
                ", Género='" + genero + '\'' +
                ", Plataforma='" + plataforma + '\'' +
                ", Disponible=" + (disponible ? "Sí" : "No") +
                '}';
    }
}
