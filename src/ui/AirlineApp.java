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

                break;

            default:

                break;

        }

    }

    public void defaultDataBase(){

        System.out.println("They are the passengers of one of our flights");

        //Print here the unsorted list of passengers, otganized by the time of arrival.

    }

    public static AirlineApp getMain() {
        return main;
    }

    public static void setMain(AirlineApp main) {
        AirlineApp.main = main;
    }

}
