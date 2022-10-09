package hi.distributed_systems.server;

import hi.distributed_systems.shared.Message;

public class Server {
     public static void main(String[] args) {
         Value v = new Value();
         final int port = 3002;

         try {
            CommunicationModuleServer communicationModule = new CommunicationModuleServer(port);
            Message msg = null;

            System.out.println("Server running on port " + port);

            while (true) {
                msg = communicationModule.waitForRequest();

                switch (msg.getMethodId()) {
                    case 1 -> v.setToZero();
                    case 2 -> v.setToFortyTwo();
                    case 3 -> msg.setArgs(v.getValue());
                }

                msg.setMessageTypeToReply();
                communicationModule.sendReply(msg);
            }
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
}
