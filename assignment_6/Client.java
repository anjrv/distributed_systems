import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            socket = new DatagramSocket();
            InetAddress ip = InetAddress.getByName(args[0]);
            Person p = new Person("John", "Reykjavík", (int) Math.round(Math.random() * 100));
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(p);
            byte[] data = os.toByteArray();
            DatagramPacket packet = new DatagramPacket(data, data.length, ip, Integer.parseInt(args[1]));
            socket.send(packet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
