import java.io.*;
import java.net.*;

class Clientdns {
    public static void main(String[] args) {
        try {
            // Create a UDP socket
            DatagramSocket client = new DatagramSocket();
            InetAddress addr = InetAddress.getByName("127.0.0.1");

            byte[] sendbyte = new byte[1024];
            byte[] receivebyte = new byte[1024];

            // Get domain name or IP address from the user
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the DOMAIN NAME or IP Address: ");
            String input = in.readLine();

            // Send the input to the server
            sendbyte = input.getBytes();
            DatagramPacket sender = new DatagramPacket(sendbyte, sendbyte.length, addr, 1309);
            client.send(sender);

            // Receive the response from the server
            DatagramPacket receiver = new DatagramPacket(receivebyte, receivebyte.length);
            client.receive(receiver);
            String response = new String(receiver.getData(), 0, receiver.getLength());
            System.out.println("Resolved IP Address or DOMAIN NAME: " + response);

            client.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
