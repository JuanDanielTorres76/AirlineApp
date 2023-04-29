package model;

import java.io.*;
import java.net.URLConnection;

public class Reader {
    
    ObjectInputStream reader; 

    public Reader(File file){

        try{

            reader = new ObjectInputStream(new FileInputStream(file));

        }catch(IOException e){

            e.printStackTrace();

        }

    }

    public Reader(URLConnection connection){

        try {

            reader = new ObjectInputStream(connection.getInputStream());

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    
    public ObjectInputStream getReader() {

        return reader;

    }

}
