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
                "\n<<<<< Welcome to the boarding and disembarkation system >>>>>\n"+
                        "1. Order of arrival\n"+
                        "2. Embark\n"+
                        "3. Disembark\n"+
                        "0. Exit. \n"+
                        "Option: ");
    }

    public void executeOption(int option){

        switch(option){
            case 1-> orderOfArrival();

            case 2-> orderOfEmbark();

            case 3 -> disembark();

            case 0-> System.out.println("Exit program.");

            default-> System.out.println("Invalid Option");
        }
    }

    /**
     * @param: Option that gives the user
     * @return: Validates the option and if the user gives a number that doesnt exist will give (Invalid Option) or even with letters (Invalid Option)
     */
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
        System.out.println("Para continuar dame la ruta en donde se encuentre el archivo por orden de llegada.");
        reader.nextLine();
        String archivo = reader.nextLine();
        controller.orderPassenger(archivo);
    }
    public void txtReader(){
        System.out.println("Dame la direccion de donde se encuentre el archivo con la informacion de los pasajeros ");
        String dir = reader.next();
        reader.nextLine();
        System.out.println("Dame la cantidad de pasajeros que van a estar en el vuelo ");
        int num = reader.nextInt();
        controller.uploadPassengers(dir, num);
    }
    public void disembark(){
        controller.disembark();
    }


}
