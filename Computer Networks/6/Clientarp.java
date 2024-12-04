import java.io.*;
import java.net.*;

class Clientarp {
    public static void main(String[] args) {
        try {
            // Create a connection to the server at localhost on port 139
            Socket clientSocket = new Socket("127.0.0.1", 139);
            
            // Input and output streams for communication
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            DataInputStream serverInput = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream serverOutput = new DataOutputStream(clientSocket.getOutputStream());
            
            // Prompt the user for an IP address
            System.out.print("Enter the Logical address (IP): ");
            String ipAddress = userInput.readLine();
            
            // Send the IP address to the server
            serverOutput.writeBytes(ipAddress + '\n');
            
            // Receive the MAC address from the server
            String macAddress = serverInput.readLine();
            System.out.println("The Physical Address is: " + macAddress);
            
            // Close the connection
            clientSocket.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
