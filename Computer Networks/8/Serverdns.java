import java.io.*;
import java.net.*;

class Serverdns {
    public static void main(String[] args) {
        try {
            // Create a UDP socket to listen on port 1309
            DatagramSocket server = new DatagramSocket(1309);
            System.out.println("DNS Server is running...");

            while (true) {
                byte[] sendbyte = new byte[1024];
                byte[] receivebyte = new byte[1024];

                // Receive the client's request
                DatagramPacket receiver = new DatagramPacket(receivebyte, receivebyte.length);
                server.receive(receiver);
                String request = new String(receiver.getData(), 0, receiver.getLength());

                // Resolve the domain name or IP address
                String[] ipAddresses = {"165.165.80.80", "165.165.79.1"};
                String[] domainNames = {"www.aptitudeguru.com", "www.downloadcyclone.blogspot.com"};
                String response = "Not Found";

                for (int i = 0; i < ipAddresses.length; i++) {
                    if (request.equals(ipAddresses[i])) {
                        response = domainNames[i];
                        break;
                    } else if (request.equals(domainNames[i])) {
                        response = ipAddresses[i];
                        break;
                    }
                }

                // Send the resolved information back to the client
                InetAddress clientAddress = receiver.getAddress();
                int clientPort = receiver.getPort();
                sendbyte = response.getBytes();
                DatagramPacket sender = new DatagramPacket(sendbyte, sendbyte.length, clientAddress, clientPort);
                server.send(sender);

                System.out.println("Resolved: " + request + " -> " + response);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
