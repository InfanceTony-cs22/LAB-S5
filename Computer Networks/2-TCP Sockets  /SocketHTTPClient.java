import java.io.*;
import java.net.*;

public class SocketHTTPClient {

    public static void main(String[] args) {
        String hostName = "www.gmail.com";
        int portNumber = 80;

        try (Socket socket = new Socket(hostName, portNumber);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Send HTTP GET request
            out.println("GET / HTTP/1.1");
            out.println("Host: " + hostName);
            out.println("Connection: close"); // Ensures the server closes the connection
            out.println(); // Blank line to indicate the end of the request header

            // Read and print the response
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        }
    }
}
