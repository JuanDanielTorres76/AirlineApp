import model.*;

import java.util.Scanner;

import model.Category;

import model.Priority;

public class AirlineApp {

    private static AirlineApp main;
    
    private AirlineManager manager;

    public static Scanner read = new Scanner(System.in);

    

    public AirlineApp(){

        manager = new AirlineManager();

    }

    public static void main(String[] args) {
    
        startApp();

    }

    public static void startApp(){

        System.out.println("Welcome to our airline! ");

        main = new AirlineApp();

        main.startMenu();

    }

    public void startMenu(){

        System.out.println("Choose one of the next options");

        System.out.println(" 1 - Use our default data base");

        System.out.println(" 2 - Create a new data base ");

        int option = read.nextInt();

        read.nextLine();

        switch(option){

            case 1: 

                main.defaultDataBase();

                break;
        
            case 2:

                main.newDataBase();

                break;

            default:

                System.out.println("Choose a valid option");

                break;

        }

    }

    public void defaultMenu(){

        boolean runnign = true;

        while(runnign){

            System.out.println("Choose one of these options");

            System.out.println(" 1 - Show unorganized passengers");

            System.out.println(" 2 - Search one passenger");

            System.out.println(" 3 - Organize Passengers according their boarding prioritization");

            System.out.println(" 4 - Organize passengers according to their departure prioritization");

            System.out.println(" 5 - End program");

            int option = read.nextInt();

            read.nextLine();

            switch(option){

                case 1:

                    System.out.println(manager.printPassengers());

                    break;

                case 2:

                    System.out.println(searchPassenger());

                    break;

                case 3:

                    organizeBoardingPassengers();

                    break;

                case 4: 

                    organizeDeparturePassenger();

                    break;

                case 5: 

                    System.out.println("Thank you for using our program");

                    runnign = false;

                    break;

                default:

                    break;

            }

        }

        manager.deleteFile();

    }

    public void newBaseMenu(){

        boolean runnign = true;

        while(runnign){

            System.out.println("Choose one of these options");

            System.out.println(" 1 - Show unorganized passengers");

            System.out.println(" 2 - Search one passenger");

            System.out.println(" 3 - Organize Passengers according their boarding prioritization");

            System.out.println(" 4 - Organize passengers according to their departure prioritization");

            System.out.println(" 5 - End program");

            int option = read.nextInt();

            read.nextLine();

            switch(option){

                case 1:

                    System.out.println(manager.recoverPassengers());

                    break;

                case 2:

                    System.out.println(main.searchPassenger());

                    break;

                case 3:

                    organizeBoardingPassengers();

                    break;

                case 4: 

                    organizeDeparturePassenger();

                    break;

                case 5: 

                    System.out.println("Thank you for using our program");

                    runnign = false;

                    break;

                default:

                    break;

            }

        }

        manager.deleteFile();

    }

    public void organizeBoardingPassengers(){

        System.out.println(manager.organizeBoardingPassengers());

        System.out.println(manager.printPassengers());

    }

    public void organizeDeparturePassenger(){

        System.out.println(manager.organizeDeparturePassenger());


    }

    public void defaultDataBase(){

        System.out.println("You are gonna use the defaul dataBase of one of our fligths");

        System.out.println(manager.initializeWithCurrentFile()); 

       defaultMenu(); 

    }

    public Priority getPriority(int option){

        Priority p;

        switch(option){

            case 1: 

                p =  Priority.THIRDAGE;

                break;

            case 2: 

                p =  Priority.PREGNANT;

                break;

            
            case 3: 

                p =  Priority.SMALLKID;

                break;    

            
            case 4: 

                p =  Priority.SPECIALATTENTION;

                break;

            
            case 5: 

                p =  Priority.NONE;

                break;

            default:

                p =  Priority.NONE;

                break;
        }

        return p;


    }

    public Category getCategory(int option){

        Category c;

        switch(option){

            case 1: 

                c = Category.SILVER;
                break;

            case 2: 

                c =  Category.GOLD;

                break;

            
            case 3: 

                c =  Category.PLATINUM;

                break;  
                
            default: 
                
                c = Category.SILVER;

                break;
        }

        return c;
    }

    public String searchPassenger(){

        System.out.println("Type the id of the passenger");

        String id = read.nextLine();

        return manager.searchPassenger(id);


    }

    public String registerPassengers(int counter, int numPassengers){

        String msg = "";

        if(counter <= numPassengers){

            System.out.println("Type the name of the Passenger ");

            String name = read.nextLine();

            System.out.println(" Type the last name of the passenger");

            String lastName = read.nextLine();

            System.out.println("Type the id of the Passenger");

            String id = read.nextLine();

            System.out.println(" Choose one of the next options if the passeger applies to any of these conditions ");

            System.out.println(" 1 - Third Age");

            System.out.println(" 2 - Pregnant");

            System.out.println(" 3 - Child under 5 years old");

            System.out.println(" 4 - Special Atention");

            System.out.println(" 5 - None ");

            int option1 = read.nextInt();

            read.nextLine();

            Priority priority = getPriority(option1);

            System.out.println("Choose one of the next flight categories the passenger belongs");

            System.out.println(" 1 - Silver");

            System.out.println(" 2 - Gold");

            System.out.println(" 3 - Platinum");

            int option2 = read.nextInt();

            read.nextLine();

            Category category = getCategory(option2);

            System.out.println(manager.registerPassengers(name, lastName, id, priority, category));

            registerPassengers(counter+1, numPassengers);

        }else{

            msg = "The passengers have been sucesfully added";

        }

        return msg;

    }

    public void newDataBase(){                         

        System.out.println(manager.addNewFile()); 

        System.out.println(" Type the numbers of passengers inside the fligth, the maximum amount is 30");

        int numPassengers = read.nextInt();

        read.nextLine();

        if(numPassengers > 30){

            System.out.println(" Remember the max amount of passengers is 30");

            numPassengers = read.nextInt();

            read.nextLine();

        }else{

            System.out.println(registerPassengers(0 , numPassengers)); 

            System.out.println(manager.exportPassengers());

        }

        newBaseMenu();

    }

    public static AirlineApp getMain() {

        return main;

    }

    public static void setMain(AirlineApp main) {

        AirlineApp.main = main;

    }

}
