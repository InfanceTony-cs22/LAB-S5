import java.io.*;
import java.net.*;

public class fc {
    public static void main(String args[]) throws IOException {
        Socket socket = null;
        BufferedReader in = null;

        try {
            // Connect to the server at localhost on port 1187
            socket = new Socket(InetAddress.getLocalHost(), 1187);
            System.out.println("Connected to the server.");

            // Initialize input stream to receive data from the server
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Read and display the file content received from the server
            String line;
            System.out.println("The content of the file is:");
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

            System.out.println("The file was received successfully.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            // Close all resources
            if (in != null) in.close();
            if (socket != null) socket.close();
        }
    }
}
