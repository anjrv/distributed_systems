import java.rmi.Naming;

public class Server {
    public static void main(String args[]) {
        System.setSecurityManager(new SecurityManager());

        try {
            CounterServant counterServant = new CounterServant();
            String registryServername = "localhost";
            String servicename = "counter";
            Naming.rebind("//" + registryServername + "/" + servicename, counterServant);
        } catch (Exception e) {
            System.err.println("Exception:" + e.toString());
            e.printStackTrace();
        }
    }
}
