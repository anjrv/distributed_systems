import java.net.*;
import java.io.*;

public class SingleClient {
    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            socket = new DatagramSocket();
            InetAddress ip = InetAddress.getByName(args[0]);

            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);

            Person p = new Person(args.length > 2 ? args[2] : "John", args.length > 3 ? args[3] : "Reykjavík",
                    (int) Math.round(Math.random() * 100));

            oos.writeObject(p);
            byte[] data = os.toByteArray();

            DatagramPacket packet = new DatagramPacket(data, data.length, ip, Integer.parseInt(args[1]));
            socket.send(packet);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }
}
