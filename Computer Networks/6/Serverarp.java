import java.io.*;
import java.net.*;

class Serverarp {
    public static void main(String[] args) {
        try {
            // Start the server on port 139
            ServerSocket serverSocket = new ServerSocket(139);
            System.out.println("Server started. Waiting for clients...");
            
            // Accept a client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // IP-to-MAC address mapping
            String[] ipAddresses = {"165.165.80.80", "165.165.79.1"};
            String[] macAddresses = {"6A:08:AA:C2", "8A:BC:E3:FA"};
            
            while (true) {
                // Input and output streams for communication
                DataInputStream clientInput = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream clientOutput = new DataOutputStream(clientSocket.getOutputStream());
                
                // Read the IP address from the client
                String requestedIp = clientInput.readLine();
                String macAddress = "MAC Address Not Found";

                // Search for the MAC address corresponding to the IP address
                for (int i = 0; i < ipAddresses.length; i++) {
                    if (requestedIp.equals(ipAddresses[i])) {
                        macAddress = macAddresses[i];
                        break;
                    }
                }

                // Send the MAC address to the client
                clientOutput.writeBytes(macAddress + '\n');
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
