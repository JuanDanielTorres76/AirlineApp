
import java.io.*;

public class Writer {

    ObjectOutputStream writer;

    public Writer(){

        try {

            writer = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Juan\\OneDrive\\Escritorio\\Univerisdad\\Tercer semestre\\Computacion y estructuras discretas\\Tarea Integradora I\\AirlineApp\\src\\model\\DataBase.txt"));

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public File createFile(){

        File file = new File("C:\\Users\\Juan\\OneDrive\\Escritorio\\Univerisdad\\Tercer semestre\\Computacion y estructuras discretas\\Tarea Integradora I\\AirlineApp\\src\\model\\DataBase.txt");

            //Especificar que este file debe ser cambiado a partir del path de su pc.

        try {
            if(file.createNewFile()){

                System.out.println("Created File"); //Delete this validations

            }
        } catch (IOException e) {
            
            System.out.println("Unable to create the DataBase");    //Delete this validations


        }

        return file;
        
    }

    public ObjectOutputStream getWriter() {
        return writer;
    }

    public void setWriter(ObjectOutputStream writer) {
        this.writer = writer;
    }

}
