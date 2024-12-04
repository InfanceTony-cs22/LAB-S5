import java.io.*;
import java.net.*;

class tcpchatclient {
    public static void main(String args[]) {
        Socket Clt;
        PrintWriter toServer;
        BufferedReader fromUser, fromServer;

        try {
            // Determine server address (localhost or given address)
            if (args.length > 1) {
                System.out.println("Usage: java tcpchatclient [hostipaddr]");
                System.exit(-1);
            }
            if (args.length == 0) {
                Clt = new Socket(InetAddress.getLocalHost(), 5555);
            } else {
                Clt = new Socket(InetAddress.getByName(args[0]), 5555);
            }

            // Set up streams for communication
            toServer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(Clt.getOutputStream())), true);
            fromServer = new BufferedReader(new InputStreamReader(Clt.getInputStream()));
            fromUser = new BufferedReader(new InputStreamReader(System.in));

            String CltMsg, SrvMsg;
            System.out.println("Type \"end\" to Quit");
            while (true) {
                // Send message to the server
                System.out.print("\nMessage to Server : ");
                CltMsg = fromUser.readLine();
                toServer.println(CltMsg);

                if (CltMsg.equals("end")) {
                    break; // End communication if "end" is sent
                }

                // Receive and print the response from the server
                SrvMsg = fromServer.readLine();
                System.out.println("Client <<< " + SrvMsg);
            }

            // Close all resources
            fromServer.close();
            toServer.close();
            fromUser.close();
            Clt.close();
        } catch (Exception E) {
            System.out.println("Error: " + E.getMessage());
        }
    }
}
