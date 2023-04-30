package datastructures.model;

import java.nio.file.Files;

import java.nio.file.Paths;

import java.time.LocalTime;

import java.io.*;

import java.util.ArrayList;
<<<<<<< HEAD

=======
import java.util.Iterator;
>>>>>>> 16d40d95128cd49f2ba0cd0911f5b5cd39637f20
import java.util.stream.Stream;

public class Controller {

    private Plane<Integer, Passenger> hashTable;

    private Priority<Passenger> firstClass;

    private Queue<Passenger> turistClass;

    private LocalTime timeOfPlane;

    public Controller() {

        firstClass = new Priority<>();

        turistClass = new Queue<>();

        timeOfPlane = LocalTime.now();
    }

    public LocalTime getTimeOfPlane(){

        return timeOfPlane;
    }

    public void setTimeOfPlane(){

        this.timeOfPlane = timeOfPlane;
    }

    public void uploadPassengers(String archivo, int num) {

        File file = new File(archivo);

        hashTable = new Plane<>(num);

        try {

            FileInputStream fis = new FileInputStream(file);

            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] atributs = line.split(";");

                Passenger passenger = new Passenger(atributs[0], Integer.parseInt(atributs[1]), Integer.parseInt(atributs[2]),Integer.parseInt(atributs[3]),

                        Integer.parseInt(atributs[4]),atributs[5],Boolean.parseBoolean(atributs[6]));

                hashTable.insert(Integer.parseInt(atributs[1]),passenger);
            }

            fis.close();

        } catch (FileNotFoundException error) {

            error.printStackTrace();

        } catch (IOException error) {

            error.printStackTrace();
        }
    }

    public void orderPassenger(String filePath) {

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {

            lines.forEach(line -> {

                String[] atributs = line.split(" ");

                Passenger passenger = hashTable.get(Integer.parseInt(atributs[0]));

                if (passenger != null) {

                    passenger.toString();

                    passenger.setTime(LocalTime.now());

                    if (passenger.getTime().isBefore(getTimeOfPlane())) {

                        passenger.setMiles(passenger.getMiles() + 100);

                    }

                    if (passenger.getFirstClass()) {

                        firstClass.insert(passenger);

                    } else {

                        turistClass.enqueue(passenger);
                    }

                } else {

                    System.out.println("No se encontro el pasajero, intenta nuevamente (Revisa que la direccion que estas poniendo este bien escrita y que en cada salto de arhcivo este un \\)");

                }
            });

        } catch (IOException error) {

            error.printStackTrace();

        }
    }

<<<<<<< HEAD
    public void disembark() {

=======
    public ArrayList<String> disembark() {
        ArrayList<String> desabordando = new ArrayList<>();
        Queue<Passenger> primeraClase = new Queue<>();
        Queue<Passenger> claseEconomica = new Queue<>();
    
        Iterator<Passenger> iterator = Passenger.iterator();
    
        while (iterator.hasNext()) {
            Passenger pasajero = iterator.next();
            if (pasajero.getClass().equals("primera")) {
                primeraClase.enqueue(pasajero);
                iterator.remove();
            } else {
                claseEconomica.enqueue(pasajero);
                iterator.remove();
            }
        }
    
        while (!primeraClase.isEmpty() || !claseEconomica.isEmpty()) {
            if (!primeraClase.isEmpty()) {
                Passenger pasajero = primeraClase.dequeue();
                desabordando.add(pasajero.getName());
            } else {
                Passenger pasajero = claseEconomica.dequeue();
                desabordando.add(pasajero.getName());
            }
        }
    
        return desabordando;
>>>>>>> 16d40d95128cd49f2ba0cd0911f5b5cd39637f20
    }
    
    

    public void order(){

        firstClass.print();

        turistClass.print();
        
    }
}
