import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) {
        try {
            // Create a server socket listening on port 2100
            ServerSocket serverSocket = new ServerSocket(2100);
            System.out.println("Server is running and waiting for a client...");

            // Accept a connection from the client
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Set up input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Receive message from the client
            String clientMessage = in.readUTF();
            System.out.println("The message from the client is: " + clientMessage);

            // Echo the message back to the client
            out.writeUTF(clientMessage);

            // Close resources
            in.close();
            out.close();
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
