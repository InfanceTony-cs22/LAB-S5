import java.io.*;
import java.net.*;

class Clientrarp {
    public static void main(String[] args) {
        try {
            // Establish connection to the server
            Socket clientSocket = new Socket("127.0.0.1", 139);

            // Input and output streams for communication
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            DataInputStream serverInput = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream serverOutput = new DataOutputStream(clientSocket.getOutputStream());

            // Prompt the user for a MAC address
            System.out.print("Enter the Physical Address (MAC): ");
            String macAddress = userInput.readLine();

            // Send the MAC address to the server
            serverOutput.writeBytes(macAddress + '\n');

            // Receive the IP address from the server
            String ipAddress = serverInput.readLine();
            System.out.println("The Logical Address (IP) is: " + ipAddress);

            // Close the connection
            clientSocket.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
