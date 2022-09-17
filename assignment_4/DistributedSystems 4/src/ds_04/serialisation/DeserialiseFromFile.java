package ds_04.serialisation;

import java.io.*;

public class DeserialiseFromFile {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            InputStream is = new FileInputStream("serialisedPersonObject.bin");
            ObjectInputStream ois = new ObjectInputStream(is);
            Object deserialisedObject = ois.readObject();
            ois.close();
            Person deserialisedPerson = (Person) deserialisedObject;
            deserialisedPerson.printValues();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
