package com.example;

public class Main {
    public static void main(String[] args){
        // Crear una instancia del gestor de videojuegos
        GestorVideojuegos gestor = new GestorVideojuegos();


        // Añadir algunos videojuegos al sistema automáticamente
        gestor.añadirVideojuegos(new Videojuego("V001", "The Witcher 3", "CD Projekt Red", "Acción", "PC", true));
        gestor.añadirVideojuegos(new Videojuego("V002", "Stardew Valley", "ConcernedApe", "Simulación", "PC", true));
        gestor.añadirVideojuegos(new Videojuego("V003", "Halo Infinite", "343 Industries", "Acción", "Xbox", true));


        // Mostrar todos los videojuegos disponibles
        System.out.println("Lista de videojuegos después de añadir:");
        gestor.mostrarVideojuegosPorGenero("Acción");
        gestor.mostrarVideojuegosPorGenero("Simulación");


        // Modificar la disponibilidad de un videojuego
        gestor.prestrarVideojuego("V001");
 	  
        gestor.mostrarVideojuegosPorGenero("Acción");
        gestor.devolverVideojuego("V001");


        
        // Mostrar el estado actual de los videojuegos
        System.out.println("Estado actual de los videojuegos:");
        gestor.mostrarVideojuegosPorGenero("Acción");
        gestor.mostrarVideojuegosPorGenero("Simulación");




        // Guardar los datos al final de la sesión
        gestor.guardarDatos();
    }
}

