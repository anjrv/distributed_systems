package hi.distributed_systems.server;

import hi.distributed_systems.shared.Message;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class CommunicationModuleServer {
    private DatagramSocket socket = null;

    public CommunicationModuleServer(int port) throws SocketException {
        this.socket = new DatagramSocket(port);
    }

    public Message waitForRequest() throws IOException, ClassNotFoundException {
        byte[] buffer = new byte[8000];
        DatagramPacket request = new DatagramPacket(buffer, buffer.length);
        socket.receive(request);

        Message message = Message.deserializeFromByteArray(request.getData());
        message.setPort(request.getPort());

        return message;
    }

    public void sendReply(Message message) throws IOException {
        message.setMessageTypeToReply();
        byte[] serializedReplyMessage = message.serializeToByteArray();

        DatagramPacket packet = new DatagramPacket(serializedReplyMessage, serializedReplyMessage.length, message.getInetAddress(), message.getPort());
        socket.send(packet);
    }
}
