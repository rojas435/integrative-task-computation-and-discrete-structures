package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.*;

public class Main {
    
    public static void main(String[] args) {
        
        // Crear un objeto de tipo SalaAbordaje
        BoardingRoom sala = new BoardingRoom();
        
        // Leer el archivo de texto con los datos de los pasajeros
        try {
            File file = new File("datos.txt");
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String nombre = parts[0].trim();
                String apellido = parts[1].trim();
                String clase = parts[2].trim();
                int fila = Integer.parseInt(parts[3].trim());
                int columna = Integer.parseInt(parts[4].trim());
                Passenger pasajero = new Passenger(nombre, apellido, clase, fila, columna);
                sala.registrarLlegada(pasajero);
            }
            
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }
        
        // Mostrar la lista de pasajeros en orden de llegada
        System.out.println("Lista de pasajeros en orden de llegada:");
        for (Passenger pasajero : sala.getPasajerosEnOrdenDeLlegada()) {
            System.out.println(pasajero);
        }
        
        // Mostrar la lista de pasajeros en orden de ingreso al avión
        System.out.println("Lista de pasajeros en orden de ingreso al avión:");
        for (Passenger pasajero : sala.getPasajerosEnOrdenDeLlegada()) {
            System.out.println(pasajero);
        }
        
        // Crear un objeto de tipo Avion
        Plane avion = new Plane();
        
        // Asignar los pasajeros a los asientos del avión
        for (Passenger pasajero : sala.getPasajerosEnOrdenDeLlegada()) {
            avion.asignarAsiento(pasajero);
        }
        
        // Mostrar la lista de pasajeros en orden de salida del avión
        System.out.println("Lista de pasajeros en orden de salida del avión:");
        for (Passenger pasajero : avion.getPasajerosEnOrdenDeSalida()) {
            System.out.println(pasajero);
        }
    }
}
