import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CounterServant extends UnicastRemoteObject implements CounterInterface {
    private int count = 0;

    protected CounterServant() throws RemoteException {
        super();
    }

    public void incrementCounter() throws RemoteException {
        this.count++;
    }

    public int getCount() throws RemoteException {
        return this.count;
    }

    public void printCount() throws RemoteException {
        System.out.println(this.count);
    }
}
