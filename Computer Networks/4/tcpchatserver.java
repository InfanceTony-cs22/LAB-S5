import java.io.*;
import java.net.*;

class tcpchatserver {
    public static void main(String args[]) {
        PrintWriter toClient;
        BufferedReader fromUser, fromClient;

        try {
            // Create a server socket listening on port 5555
            ServerSocket Srv = new ServerSocket(5555);
            System.out.println("\nServer started");

            // Wait for a client to connect
            Socket Clt = Srv.accept();
            System.out.println("Client connected");

            // Set up streams for communication
            toClient = new PrintWriter(new BufferedWriter(new OutputStreamWriter(Clt.getOutputStream())), true);
            fromClient = new BufferedReader(new InputStreamReader(Clt.getInputStream()));
            fromUser = new BufferedReader(new InputStreamReader(System.in));

            String CltMsg, SrvMsg;
            while (true) {
                // Read message from the client
                CltMsg = fromClient.readLine();
                if (CltMsg.equals("end")) {
                    break; // End communication if "end" is received
                } else {
                    System.out.println("\nServer <<< " + CltMsg);

                    // Send a message back to the client
                    System.out.print("Message to Client : ");
                    SrvMsg = fromUser.readLine();
                    toClient.println(SrvMsg);
                }
            }

            System.out.println("\nClient Disconnected");

            // Close all resources
            fromClient.close();
            toClient.close();
            fromUser.close();
            Clt.close();
            Srv.close();
        } catch (Exception E) {
            System.out.println("Error: " + E.getMessage());
        }
    }
}
