import java.net.*;
import java.io.*;

public class SingleServer {
    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            socket = new DatagramSocket(Integer.parseInt(args[0]));
            byte[] buffer = new byte[1024];

            for (;;) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                byte[] data = packet.getData();
                ByteArrayInputStream in = new ByteArrayInputStream(data);
                ObjectInputStream ois = new ObjectInputStream(in);

                System.out.println("Received: " + (Person) ois.readObject());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }
}
