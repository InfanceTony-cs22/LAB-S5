import java.io.*;
import java.net.*;

class Serverrarp {
    public static void main(String[] args) {
        try {
            // Start the server on port 139
            ServerSocket serverSocket = new ServerSocket(139);
            System.out.println("RARP Server started. Waiting for client...");

            // Accept a client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // MAC-to-IP address mapping
            String[] macAddresses = {"6A:08:AA:C2", "8A:BC:E3:FA"};
            String[] ipAddresses = {"165.165.80.80", "165.165.79.1"};

            while (true) {
                // Input and output streams for communication
                DataInputStream clientInput = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream clientOutput = new DataOutputStream(clientSocket.getOutputStream());

                // Read the MAC address from the client
                String requestedMac = clientInput.readLine();
                String ipAddress = "IP Address Not Found";

                // Search for the IP address corresponding to the MAC address
                for (int i = 0; i < macAddresses.length; i++) {
                    if (requestedMac.equals(macAddresses[i])) {
                        ipAddress = ipAddresses[i];
                        break;
                    }
                }

                // Send the IP address to the client
                clientOutput.writeBytes(ipAddress + '\n');
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
