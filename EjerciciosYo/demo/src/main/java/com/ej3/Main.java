package com.ej3;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventoGestor gestor = new EventoGestor();

        try {
            gestor.leerEventos();
            System.out.println("Eventos cargados correctamente.");
        } catch (IOException e) {
            System.out.println("No se pudo cargar el archivo inicial o está vacío.");
        }

        int opcion = 0;

        do {
            System.out.println("\n--- GESTOR DE CALENDARIO DE EVENTOS ---");
            System.out.println("1. Añadir nuevo evento");
            System.out.println("2. Listar eventos existentes");
            System.out.println("3. Eliminar evento");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, introduce un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el ID del evento (ej. E003): ");
                    String id = scanner.nextLine();
                    
                    System.out.print("Introduce el título del evento: ");
                    String titulo = scanner.nextLine();
                    
                    System.out.print("Introduce la fecha (YYYY-MM-DD): ");
                    String fecha = scanner.nextLine();
                    
                    System.out.print("¿Está completado? (true/false): ");
                    boolean completado = Boolean.parseBoolean(scanner.nextLine());

                    Evento nuevoEvento = new Evento(id, titulo, fecha, completado);
                    gestor.añadirEventos(nuevoEvento);
                    System.out.println("✅ Evento añadido y guardado en el archivo JSON.");
                    break;

                case 2:
                    System.out.println("--- Lista de Eventos ---");
                    gestor.listarEventosExistentes();
                    break;

                case 3:
                    System.out.print("Introduce el ID del evento que deseas eliminar: ");
                    String idEliminar = scanner.nextLine();
                    gestor.eliminarEventos(idEliminar);
                    System.out.println("✅ Si el evento existía, ha sido eliminado y el archivo JSON ha sido actualizado.");
                    break;

                case 4:
                    System.out.println("Saliendo del programa. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del 1 al 4.");
            }

        } while (opcion != 4);

        scanner.close();
    }
}
