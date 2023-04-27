import java.io.*;

import java.net.URL;

import java.net.URLConnection;

import java.util.ArrayList;

public class AirlineManager {
    
    private Writer w;

    private Reader r;

    private File file;

    private ArrayList<Passenger> passengers;

    public AirlineManager(){

        this.file = null;

        passengers = new ArrayList<Passenger>(); 

    }

    public String exportPassengers(int counter){

        if(counter < passengers.size()){

            try {

                w.getWriter().writeObject(passengers.get(counter));

                w.getWriter().close();

                exportPassengers(counter+1);

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

        return "Exported dataBase";

    }

    public String registerPassengers(String name, String lastName, String id, Priority priority, Category category){

        Passenger newPassenger = new Passenger(name, lastName, id, priority, category);

        passengers.add(newPassenger);

        return "passenger " + newPassenger.getName() + ": Added "; 
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

    public void initializeWithCurrentFile(){

        try {

            URL url = new URL("https://github.com/JuanDanielTorres76/AirlineApp/blob/main/src/model/DataBase.txt");

            URLConnection connection = url.openConnection();

            r = new Reader(connection);

        } catch (Exception e) {

            e.printStackTrace();

        }


        
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
    

}
