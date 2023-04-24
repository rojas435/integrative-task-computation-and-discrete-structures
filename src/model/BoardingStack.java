package model;

public class BoardingStack {
    private Passenger[] pila;
    private int tope;

    public BoardingStack(int capacidad) {
        pila = new Passenger[capacidad];
        tope = -1;
    }

    public boolean estaVacia() {
        return tope == -1;
    }

    public boolean estaLlena() {
        return tope == pila.length - 1;
    }

    public void apilar(Passenger pasajero) {
        if (estaLlena()) {
            System.out.println("La pila está llena, no se puede apilar el pasajero");
            return;
        }
        tope++;
        pila[tope] = pasajero;
    }

    public Passenger desapilar() {
        if (estaVacia()) {
            System.out.println("La pila está vacía, no se puede desapilar ningún pasajero");
            return null;
        }
        Passenger pasajeroDesapilado = pila[tope];
        pila[tope] = null;
        tope--;
        return pasajeroDesapilado;
    }
}
