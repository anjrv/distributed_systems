import java.util.concurrent.*;
import java.net.*;
import java.io.*;

public class PoolServer {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[1]);
        ExecutorService executor = Executors.newFixedThreadPool(N);

        try {
            DatagramSocket socket = new DatagramSocket(Integer.parseInt(args[0]));
            for (int i = 0; i < N; i++) {
                Runnable worker = new PoolWorker(socket, i);
                executor.execute(worker);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
