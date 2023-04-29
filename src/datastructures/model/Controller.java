package datastructures.model;
import java.time.LocalTime;
import java.io.*;
import java.util.ArrayList;
import java.nio.charset.StandardCharsets;


public class Controller {

    private ImplementationHash<Integer, Passenger> hashTable;

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
        hashTable = new ImplementationHash<>(num);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] atribute = line.split(";");
                Passenger passenger = new Passenger(atribute[0], Integer.parseInt(atribute[1]), Integer.parseInt(atribute[2]),
                        Integer.parseInt(atribute[3]), Integer.parseInt(atribute[4]), atribute[5], Boolean.parseBoolean(atribute[6]));
                hashTable.insert(Integer.parseInt(atribute[1]), passenger);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
