package com.ej2;

public class Proyecto {
    private String nombre;
    private String líder;
    private int duración;
    private double presupuesto;


    // Constructor vacío necesario para deserialización Jackson
    public Proyecto() {}


    // Constructor con todos los atributos
    public Proyecto(String nombre, String líder, int duración, double presupuesto) {
        this.nombre = nombre;
        this.líder = líder;
        this.duración = duración;
        this.presupuesto = presupuesto;
    }


    // Getters y setters
    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getLíder() {
        return líder;
    }


    public void setLíder(String líder) {
        this.líder = líder;
    }


    public int getDuración() {
        return duración;
    }


    public void setDuración(int duración) {
        this.duración = duración;
    }


    public double getPresupuesto() {
        return presupuesto;
    }


    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }


    @Override
    public String toString() {
        return "Proyecto{" +
                "nombre='" + nombre + '\'' +
                ", líder='" + líder + '\'' +
                ", duración=" + duración +
                ", presupuesto=" + presupuesto +
                '}';
    }
}

