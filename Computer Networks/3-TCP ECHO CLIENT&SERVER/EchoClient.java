import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) {
        try {
            // Connect to the server at localhost on port 2100
            Socket socket = new Socket(InetAddress.getLocalHost(), 2100);

            // Set up input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // Send a message to the server
            System.out.println("Enter the message:");
            String messageToSend = br.readLine();
            out.writeUTF(messageToSend);

            // Receive and display the echoed message
            String echoedMessage = in.readUTF();
            System.out.println("The message echoed from the server is: " + echoedMessage);

            // Close resources
            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
