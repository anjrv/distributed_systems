import java.net.*;
import java.io.*;

public class MultiServer {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(Integer.parseInt(args[0]));

            for (;;) {
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                new Thread(new DatagramReader(packet)).start();

            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
