package model;

public class BoardingRoom {
    private Plane avion;
    private BoardingStack pilaAbordaje;
    
    public BoardingRoom(int capacidad, int numFilas, int asientosPorFila) {
        this.avion = new Plane(capacidad, numFilas, asientosPorFila);
        this.pilaAbordaje = new BoardingStack(capacidad);
    }
    
    public BoardingRoom() {
    }

    public boolean agregarPasajero(Passenger pasajero) {
        if (this.avion.agregarPasajero(pasajero)) {
            this.pilaAbordaje.apilar(pasajero);
            return true;
        }
        return false;
    }
    
    public boolean abrirPuerta() {
        if (!this.pilaAbordaje.estaVacia()) {
            Passenger pasajero = this.pilaAbordaje.desapilar();
            System.out.println("El pasajero " + pasajero.getNombre() + " ha abordado el avión.");
            return true;
        }
        return false;
    }

    public Passenger sacarPasajero() {
        return null;
    }

    public void mostrarPasajeros() {
    }

    public void registrarLlegada(Passenger pasajero) {
    }

    public Passenger[] getPasajerosEnOrdenDeLlegada() {
        return null;
    }
}

