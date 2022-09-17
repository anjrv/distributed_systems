package ds_04.serialisation;

import java.io.*;

public class SerialiseToFile {

    public static void main(String[] args) {
        Person person = new Person("Smith", "London", 1934);

        try {
            OutputStream os = new FileOutputStream("serialisedPersonObject.bin");

            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(person);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
