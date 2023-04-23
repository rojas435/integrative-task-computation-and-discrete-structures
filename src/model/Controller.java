package model;

import java.util.Scanner;

public class Controller {
    
    private BoardingRoom boardingRoom;
    private Plane plane;
    
    public Controller() {
        this.boardingRoom = new BoardingRoom();
        this.plane = new Plane();
    }
    
    public void addPassenger() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del pasajero: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el número de asiento: ");
        int numeroAsiento = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese la clase del pasajero (Ejecutiva, Economica, Primera): ");
        String clase = scanner.nextLine();
        Passenger pasajero = new Passenger(nombre, numeroAsiento, clase);
        this.boardingRoom.agregarPasajero(pasajero);
        System.out.println("El pasajero ha sido agregado exitosamente a la sala de abordaje.");
    }
    
    public void OpenPlaneDoor() {
        System.out.println("Abriendo puerta del avión...");
        Passenger pasajero = null;
        while ((pasajero = this.boardingRoom.sacarPasajero()) != null) {
            this.plane.agregarPasajero(pasajero);
        }
        System.out.println("Todos los pasajeros han sido abordados en el avión.");
    }
    
    public void mostrarSalaAbordaje() {
        System.out.println("Sala de Abordaje:");
        this.boardingRoom.mostrarPasajeros();
    }
    
    public void mostrarAvion() {
        System.out.println("Avión:");
        this.plane.mostrarPasajeros();
    }
}
