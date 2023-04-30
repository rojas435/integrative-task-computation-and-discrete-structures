package datastructures.ui;

import datastructures.model.Controller;

import java.util.Scanner;

public class Main {

    private Scanner reader;

    private Controller controller;


    public Main() {

        reader = new Scanner(System.in);

        controller = new Controller();

    }

    public static void main(String[] args) {

        Main main = new Main();

        main.txtReader();

        int option = -1;

        do{

            option = main.getOptionShowMenu();

            main.executeOption(option);

        }while(option != 0);
    }

    public int getOptionShowMenu(){

        int option = 0;

        printMenu();

        option = validateIntegerOption();

        return option;
    }

    public void printMenu(){

        System.out.print(
                "\n<<<<< Bienvenido al sistema de embarque y desembarque >>>>>\n"+
                        "1. Orden de llegada\n"+
                        "2. Embarcar\n"+
                        "3. Desembarcar\n"+
                        "0. Salir del programa. \n"+
                        "Opcion: ");
    }

    public void executeOption(int option){

        switch(option){

            case 1-> orderOfArrival();

            case 2-> orderOfEmbark();

            case 3 -> disembark();

            case 0-> System.out.println("\nGracias por hacer uso del programa, hasta luego.");

            default-> System.out.println("\nHas introducido una opcion invalida, intenta nuevamente.");
        }
    }

    public int validateIntegerOption(){
        int option = 0;


        if(reader.hasNextInt()){

            option = reader.nextInt();
        }

        else{

            reader.nextLine();

            option = -1;

        }

        return option;
    }
    public void orderOfEmbark(){

        controller.order();
    }

    public void orderOfArrival(){

        System.out.println("Ingresa la ruta en donde se encuentre el archivo por orden de llegada por favor: ");

        reader.nextLine();

        String archivo = reader.nextLine();

        controller.orderPassenger(archivo);
    }

    public void txtReader(){

        System.out.println("Ingresa la direccion de donde se encuentre el archivo con la informacion de los pasajeros: ");

        String dir = reader.nextLine();

        System.out.println("Ingresa la cantidad de pasajeros que van a estar en el vuelo: ");

        int num = reader.nextInt();

        controller.uploadPassengers(dir, num);

    }

    public void disembark(){

        controller.disembark();
    }


}
