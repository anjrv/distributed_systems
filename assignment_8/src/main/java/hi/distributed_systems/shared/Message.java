package hi.distributed_systems.shared;

import java.io.*;
import java.net.InetAddress;

public class Message implements Serializable {
    private static int id = 0;
    private final int messageId;
    private int messageType;
    private int methodId;
    private int port;
    private InetAddress inetAddress;
    private Object args;

    public Message() {
        this.messageId = id++;
    }

    public static Message deserializeFromByteArray(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ObjectInputStream ois = new ObjectInputStream(in);
        Message msg = (Message) ois.readObject();

        in.close();
        ois.close();

        return msg;
    }

    public void setMessageTypeToRequest() {
        this.messageType = 0;
    }

    public void setMessageTypeToReply() {
        this.messageType = 1;
    }

    public int getMessageId() {
        return this.messageId;
    }

    public int getMethodId() {
        return this.methodId;
    }

    public void setMethodId(int id) {
        this.methodId = id;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public InetAddress getInetAddress() {
        return this.inetAddress;
    }

    public void setInetAddress(InetAddress inetAddress) {
        this.inetAddress = inetAddress;
    }

    public Object getArgs() {
        return this.args;
    }

    public void setArgs(Object args) {
        this.args = args;
    }

    public byte[] serializeToByteArray() throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(this);
        byte[] data = os.toByteArray();

        os.close();
        oos.close();

        return data;
    }
}
