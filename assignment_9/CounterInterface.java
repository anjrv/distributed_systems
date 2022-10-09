import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CounterInterface extends Remote {
    void incrementCounter() throws RemoteException;

    int getCount() throws RemoteException;

    void printCount() throws RemoteException;
}
