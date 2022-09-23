import java.net.*;
import java.io.*;

public class DatagramReader implements Runnable {
    DatagramPacket packet = null;

    public DatagramReader(DatagramPacket packet) {
        this.packet = packet;
    }

    public void run() {
        try {
            byte[] data = packet.getData();
            ByteArrayInputStream in = new ByteArrayInputStream(data);
            ObjectInputStream ois = new ObjectInputStream(in);

            System.out.println("Received: " + (Person) ois.readObject());

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
