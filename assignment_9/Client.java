import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        System.setSecurityManager(new SecurityManager());
        String servicename = "counter";
        String registryServername = "localhost";

        try {
            CounterInterface counterProxy = (CounterInterface) Naming
                    .lookup("//" + registryServername + "/" + servicename);

            System.out.println("Initial value of counter: " + counterProxy.getCount());

            for (int i = 0; i < 5; i++) {
                System.out.println("Incrementing counter...");
                counterProxy.incrementCounter();
            }

            System.out.println("Value of counter after increments: " + counterProxy.getCount());
            counterProxy.printCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
