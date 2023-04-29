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
                        "2. Disembark\n"+
                        "0. Exit. \n"+
                        "Option: ");
    }

    public void executeOption(int option){

        switch(option){
            case 1-> orderOfArrival();

            case 2-> embark();

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

    public void embark(){
        
    }
    public void orderOfArrival(){

    }
}
