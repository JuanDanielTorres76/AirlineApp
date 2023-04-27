
import java.io.*;

public class Writer {

    ObjectOutputStream writer;

    public Writer(File file){

        try {

            writer = new ObjectOutputStream(new FileOutputStream(file));

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public ObjectOutputStream getWriter() {

        return writer;
        
    }

    public void setWriter(ObjectOutputStream writer) {
        this.writer = writer;
    }

}
