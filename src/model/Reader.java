
import java.io.*;

public class Reader {
    
    ObjectInputStream reader; 

    public Reader(){

        try{

            reader = new ObjectInputStream(new FileInputStream("C:\\Users\\Juan\\OneDrive\\Escritorio\\Univerisdad\\Tercer semestre\\Computacion y estructuras discretas\\Tarea Integradora I\\AirlineApp\\src\\model\\DataBase.txt"));

        }catch(IOException e){

            e.printStackTrace();

        }

    }

    
    public ObjectInputStream getReader() {

        return reader;
        
    }

}
