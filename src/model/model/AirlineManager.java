package model;

import java.io.*;

import java.net.URL;

import java.net.URLConnection;

import java.util.ArrayList;

public class AirlineManager {
    
    private Writer w;

    private Reader r;

    private File file;

    private ArrayList<Passenger> passengers;

    private ArrayList<Passenger> recoveredPassengers;

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

    public String importPassengers(){

        try {

        recoveredPassengers = (ArrayList<Passenger>) r.getReader().readObject();

        r.getReader().close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return "Imported dataBase";

    }

    public String recoverPassengers(){

        importPassengers();

        String passengers = "";

        for(int i = 0; i <recoveredPassengers.size(); i++){

            passengers += recoveredPassengers.get(i).toString() + "\n";

        }

        return passengers;

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

    public void initializeWithCurrentFile(){

        try {

            URL url = new URL("https://github.com/JuanDanielTorres76/AirlineApp/blob/main/src/model/DataBase.txt");

            URLConnection connection = url.openConnection();

            r = new Reader(connection);

        } catch (Exception e) {

            e.printStackTrace();

        }
        
    }

    public String printPassengers(){

        importPassengers();

        String msg = "";

        for(int i = 0; i < recoveredPassengers.size(); i++){

            msg +=  i + ":" + recoveredPassengers.get(i).toString() + "\n";

        }

        return msg; 

    }

    public void deleteFile(File file){

        //Method used only if the user picks the option of creating a new Database.

        file.delete();

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

    public ArrayList<Passenger> getRecoveredPassengers() {
        return recoveredPassengers;
    }

    public void setRecoveredPassengers(ArrayList<Passenger> recoveredPassengers) {
        this.recoveredPassengers = recoveredPassengers;
    }
    

}
