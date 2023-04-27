import java.util.Scanner;

public class AirlineApp {

    private static AirlineApp main;
    
    private AirlineManager manager;

    public static Scanner read = new Scanner(System.in);

    

    public AirlineApp(){

        manager = new AirlineManager();

    }

    public static void main(String[] args) {
    


    }

    public static void startApp(){

        System.out.println("Welcome to our airline! ");

        main = new AirlineApp();

        main.menu();

    }

    public void menu(){

        System.out.println("Choose one of the next options");

        System.out.println(" 1 - Use our default data base");

        System.out.println(" 2 - Create a new data base ");

        int option = read.nextInt();

        read.nextLine();

        switch(option){

            case 1: 

                break;
        
            case 2:

                main.newDataBase();

                break;

            default:

                System.out.println("Choose a valid option");

                break;

        }

    }

    public void defaultDataBase(){

        System.out.println("They are the passengers of one of our flights");

        //Print here the unsorted list of passengers, otganized by the time of arrival.

        

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

                c = Category.Silver;
                break;

            case 2: 

                c =  Category.Gold;

                break;

            
            case 3: 

                c =  Category.Platinum;

                break;  
                
            default: 
                
                c = Category.Silver;

                break;
        }

        return c;
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

            System.out.println("Choos one of the next flight categories the passenger belongs");

            System.out.println(" 1 - Silver");

            System.out.println(" 2 - Gold");

            System.out.println(" 3 - Platinum");

            int option2 = read.nextInt();

            read.nextLine();

            Category category = getCategory(option2);

            System.out.println(manager.registerPassengers(name, lastName, id, priority, category));

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

            newDataBase();

        }else{

            System.out.println(registerPassengers(0 , numPassengers)); 

            System.out.println(manager.exportPassengers(0));

        }



    }

    public static AirlineApp getMain() {

        return main;

    }

    public static void setMain(AirlineApp main) {

        AirlineApp.main = main;

    }

}
