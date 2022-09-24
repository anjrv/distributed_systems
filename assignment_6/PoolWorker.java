import java.util.concurrent.*;
import java.net.*;
import java.io.*;

public class PoolWorker implements Runnable {
    private DatagramSocket socket = null;
    private int num;

    public PoolWorker(DatagramSocket socket, int num) {
        this.socket = socket;
        this.num = num;
    }

    public void run() {
        for (;;) {
            try {
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                socket.receive(packet);
                byte[] data = packet.getData();

                ByteArrayInputStream in = new ByteArrayInputStream(data);
                ObjectInputStream ois = new ObjectInputStream(in);

                System.out.println("Runner " + num + " Received: " + (Person) ois.readObject());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
