package model;

import java.io.*;

import java.util.ArrayList;

public class AirlineManager {
    
    private Writer w;

    private Reader r;

    private File file;

    private ArrayList<Passenger> passengers;

    private PriorityQueue<Passenger> prioritizedPassengers;

    public AirlineManager(){

        this.file = null;

        passengers = new ArrayList<Passenger>(); 

    }

    // Methods for the usage of the new database

    public String exportPassengers(){

        try {

            w.getWriter().writeObject(passengers);

            w.getWriter().close();

        } catch (IOException e) {

            e.printStackTrace();

        }

        return "Exported dataBase";

    }

    public BST<String, Passenger> fillBST(){

        BST<String, Passenger> binaryTree = new BST<String, Passenger>(null);

        for(Passenger passenger : passengers){

            binaryTree.insert(passenger.getId(), passenger);

        }

        return binaryTree;

    }

    public String searchPassenger(String id){
        
        String msg = "";

        BST<String, Passenger> binaryTree = fillBST();

        Passenger passenger = binaryTree.search(id); 

        if(passenger != null){

            msg+= passenger.toString();

        }else{

            msg = "The passenger hasnt been found";

        } 

        return msg;

    }

    public String organizeBoardingPassengers(){

        String msg = "The passengers have ben sucesfully organized";

        prioritizedPassengers = new PriorityQueue<>();

        for(int i = 0; i< passengers.size(); i++){

            for(int j = 1; j < passengers.size(); j++){

                if(passengers.get(j).compareTo(passengers.get(j-1)) > 0){

                    Passenger prevoius = passengers.get(j-1);

                    Passenger actual = passengers.get(j);

                    //Cambio

                    passengers.set(j, prevoius);

                    passengers.set(j-1, actual);

                }

            }

        }

        prioritizedPassengers.addAll(passengers);

        return msg;

    }

    public String importPassengers(){

        try {

        passengers = (ArrayList<Passenger>) r.getReader().readObject();

        r.getReader().close();

        } catch (Exception e) {

        }

        return "Imported dataBase";

    }

    public String recoverPassengers(){

        importPassengers();

        String psgs = "";

        for(int i = 0; i <passengers.size(); i++){

            psgs += i + ":" +  passengers.get(i).toString() + "\n";

        }

        return psgs;

    }

    public String registerPassengers(String name, String lastName, String id, Priority priority, Category category){

        Passenger newPassenger = new Passenger(name, lastName, id, priority, category);

        passengers.add(newPassenger);

        return "passenger " + newPassenger.getName() + ": Added \n"; 
    }

    public String addNewFile(){

        String msg = "The dataBase have been sucesfully created";

        this.file = createFile();

        initilizeWithNewFile(file);

        return msg;

    }


    private void initilizeWithNewFile(File file){

        w = new Writer(file);

        r = new Reader(file);

    }

    //Methods for the usage of the default database

    public String initializeWithCurrentFile(){

        String msg = "The actual dataBase has been sucesfully initialized";

        this.file = createDefaultDataBase();

        initilizeWithNewFile(file);

        fillDefaultDataBase(file);

        return msg;
        
    }

    public void fillDefaultDataBase(File file){

        Passenger passenger1 = new Passenger("Juan", "Perez", "1095678435", Priority.NONE, Category.GOLD);
        Passenger passenger2 = new Passenger("Pedro", "Rodriguez", "1984027653", Priority.THIRDAGE, Category.SILVER);
        Passenger passenger3 = new Passenger("Andres", "Paz", "2465245987", Priority.SPECIALATTENTION, Category.PLATINUM);
        Passenger passenger4 = new Passenger("Gabriela", "Zapata", "3454327654", Priority.PREGNANT, Category.SILVER);
        Passenger passenger5 = new Passenger("Sara", "Fernandez", "1238765235", Priority.NONE, Category.GOLD);
        Passenger passenger6 = new Passenger("Jose", "Lleras", "1349876453", Priority.THIRDAGE, Category.SILVER);
        Passenger passenger7 = new Passenger("Juan", "Eraso", "1876092376", Priority.NONE, Category.PLATINUM);
        Passenger passenger8 = new Passenger("Lucas", "Villota", "1098267653", Priority.THIRDAGE, Category.SILVER);
        Passenger passenger9 = new Passenger("Juan", "Perez", "1095678435", Priority.NONE, Category.GOLD);
        Passenger passenger10 = new Passenger("Maria", "Figueroa", "1098736475", Priority.SMALLKID, Category.GOLD);
        Passenger passenger11 = new Passenger("Marta", "Mingueza", "2315876456", Priority.PREGNANT, Category.SILVER);
        Passenger passenger12 = new Passenger("Fernanda", "Lopez", "1984523562", Priority.NONE, Category.SILVER);
        Passenger passenger13 = new Passenger("Luis", "Torres", "8916782537", Priority.THIRDAGE, Category.PLATINUM);
        Passenger passenger14 = new Passenger("Paula", "Unigarro", "3209876513", Priority.NONE, Category.GOLD);
        Passenger passenger15 = new Passenger("Manue", "Velez", "1798367526", Priority.NONE, Category.PLATINUM);
        Passenger passenger16= new Passenger("Juan", "Perez", "1095678435", Priority.NONE, Category.GOLD);
        Passenger passenger17 = new Passenger("David", "Moreno", "19867298365", Priority.SPECIALATTENTION, Category.SILVER);
        Passenger passenger18 = new Passenger("Antonia", "Salas", "18752930765", Priority.NONE, Category.SILVER);
        Passenger passenger19 = new Passenger("Sofia", "Pastrana", "1083297635", Priority.SMALLKID, Category.PLATINUM);
        Passenger passenger20 = new Passenger("Joseph", "Zapata", "1076530968", Priority.SPECIALATTENTION, Category.PLATINUM);

        passengers.add(passenger1);
        passengers.add(passenger2);
        passengers.add(passenger3);
        passengers.add(passenger4);
        passengers.add(passenger5);
        passengers.add(passenger6);
        passengers.add(passenger7);
        passengers.add(passenger8);
        passengers.add(passenger9);
        passengers.add(passenger10);
        passengers.add(passenger11);
        passengers.add(passenger12);
        passengers.add(passenger13);
        passengers.add(passenger14);
        passengers.add(passenger15);
        passengers.add(passenger16);
        passengers.add(passenger17);
        passengers.add(passenger18);
        passengers.add(passenger19);
        passengers.add(passenger20);
        try {

            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file));
            writer.writeObject(passenger1);
            writer.writeObject(passenger2);
            writer.writeObject(passenger3);
            writer.writeObject(passenger4);
            writer.writeObject(passenger5);
            writer.writeObject(passenger6);
            writer.writeObject(passenger7);
            writer.writeObject(passenger8);
            writer.writeObject(passenger9);
            writer.writeObject(passenger10);
            writer.writeObject(passenger11);
            writer.writeObject(passenger12);
            writer.writeObject(passenger13);
            writer.writeObject(passenger14);
            writer.writeObject(passenger15);
            writer.writeObject(passenger16);
            writer.writeObject(passenger17);
            writer.writeObject(passenger18);
            writer.writeObject(passenger19);
            writer.writeObject(passenger20);

            writer.close();

        } catch (IOException e) {

            e.printStackTrace();

        }


    }

    public String printPassengers(){

        String msg = importPassengers() + "\n";

        for(int i = 0; i < passengers.size(); i++){

            msg +=  (i+1) + ":" + passengers.get(i).toString() + "\n";

        }

        return msg; 

    }

    public void deleteFile(){

        this.file.delete();

    }

    private File createDefaultDataBase(){

        file = new File("DataBase.txt");

        try {

            file.createNewFile();
            
        } catch (IOException e) {

            e.printStackTrace();

        }

        return file;
        
    }

    private File createFile(){ //Change method to private, add a new one as public.

        file = new File("newDataBase.txt");

        try {

            file.createNewFile();
            
        } catch (IOException e) {

            e.printStackTrace();

        }

        return file;

    }

    public Writer getW() {

        return w;

    }

    public Reader getR() {

        return r;

    }

    public PriorityQueue<Passenger> getPrioritizedPassengers() {
        return prioritizedPassengers;
    }

}
