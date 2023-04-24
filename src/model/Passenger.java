package model;

public class Passenger {
    private String nombre;
    private String apellido;
    private int edad;
    private String clase;
    private int millasAcumuladas;
    private boolean necesitaAtencionEspecial;

    // Constructor de la clase
    public Passenger(String nombre, String apellido, int edad, String clase, int millasAcumuladas, boolean necesitaAtencionEspecial) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.clase = clase;
        this.millasAcumuladas = millasAcumuladas;
        this.necesitaAtencionEspecial = necesitaAtencionEspecial;
    }

    public Passenger(String nombre2, int numeroAsiento, String clase2) {
    }

    public Passenger(String nombre2, String apellido2, String clase2, int fila, int columna) {
    }

    // Métodos para acceder a los atributos privados
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getClase() {
        return clase;
    }

    public int getMillasAcumuladas() {
        return millasAcumuladas;
    }

    public boolean necesitaAtencionEspecial() {
        return necesitaAtencionEspecial;
    }

    // Método para imprimir la información del pasajero
    public void imprimirInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Edad: " + edad);
        System.out.println("Clase: " + clase);
        System.out.println("Millas acumuladas: " + millasAcumuladas);
        System.out.println("Necesita atención especial: " + (necesitaAtencionEspecial ? "Sí" : "No"));
    }
}
