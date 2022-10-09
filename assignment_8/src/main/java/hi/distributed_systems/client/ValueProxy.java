package hi.distributed_systems.client;

import java.io.IOException;

public class ValueProxy {
    private final CommunicationModuleClient communicationModule;

    public ValueProxy(CommunicationModuleClient communicationModule) {
        this.communicationModule = communicationModule;
    }

    public void setToZero() throws IOException, ClassNotFoundException {
        this.communicationModule.doOperation(1, null);
    }

    public void setToFortyTwo() throws IOException, ClassNotFoundException {
        this.communicationModule.doOperation(2, null);
    }

    public int getValue() throws IOException, ClassNotFoundException {
        return (Integer) this.communicationModule.doOperation(3, null);
    }
}
