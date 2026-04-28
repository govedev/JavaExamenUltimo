package com.ej3;

public class Evento {
    private String id;
    private String titulo;
    private String fecha;
    private boolean completado;


    // Constructor vacío necesario para la deserialización con Jackson
    public Evento() {
    }


    // Constructor con todos los atributos
    public Evento(String id, String titulo, String fecha, boolean completado) {
        this.id = id;
        this.titulo = titulo;
        this.fecha = fecha;
        this.completado = completado;
    }


    // Getters y Setters
    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getFecha() {
        return fecha;
    }


    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    public boolean isCompletado() {
        return completado;
    }


    public void setCompletado(boolean completado) {
        this.completado = completado;
    }


    // Método toString para imprimir detalles del evento de manera amigable
    @Override
    public String toString() {
        return "Evento{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", fecha='" + fecha + '\'' +
                ", completado=" + completado +
                '}';
    }
}
