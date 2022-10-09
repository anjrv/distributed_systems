package hi.distributed_systems.client;

import hi.distributed_systems.shared.Message;

import java.io.IOException;
import java.net.*;

public class CommunicationModuleClient {
    private final InetAddress inetAddress;
    private final int port;
    private DatagramSocket socket = null;

    public CommunicationModuleClient(String serverIp, int serverPort) throws SocketException, UnknownHostException {
        this.socket = new DatagramSocket();
        this.inetAddress = InetAddress.getByName(serverIp);
        this.port = serverPort;
    }

    public Object waitForReply() throws IOException, ClassNotFoundException {
        byte[] buffer = new byte[8000];
        DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
        socket.receive(reply);
        Message message = Message.deserializeFromByteArray(reply.getData());
        return message.getArgs();
    }

    public Object doOperation(int id, Object arg) throws IOException, ClassNotFoundException {
        Message msg = new Message();
        msg.setMessageTypeToRequest();
        msg.setMethodId(id);
        msg.setInetAddress(inetAddress);
        msg.setPort(port);

        byte[] data = msg.serializeToByteArray();
        DatagramPacket packet = new DatagramPacket(data, data.length, inetAddress, port);
        socket.send(packet);

        return waitForReply();
    }
}
