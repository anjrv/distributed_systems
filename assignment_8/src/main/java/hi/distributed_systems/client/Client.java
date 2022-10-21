package hi.distributed_systems.client;

public class Client {
    public static void main(String[] args) {
        try {
            CommunicationModuleClient communicationModule = new CommunicationModuleClient("localhost", 3002, 3003);
            ValueProxy proxy = new ValueProxy(communicationModule);

            System.out.println("Initial value seen by client is " + proxy.getValue());

            proxy.setToFortyTwo();
            System.out.println("Value received on client after setting forty two is " + proxy.getValue());

            proxy.setToZero();
            System.out.println("Value received on client after setting zero is " + proxy.getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
