import java.io.*;
import java.net.*;

public class fs {
    public static void main(String args[]) throws IOException {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        PrintWriter out = null;
        BufferedReader userInputReader = null;

        try {
            // Create a server socket listening on port 1187
            serverSocket = new ServerSocket(1187);
            System.out.println("Server is listening on port 1187...");

            // Accept a client connection
            clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket);

            // Initialize output stream to send data to the client
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read the file name from the user
            userInputReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the text file name to send: ");
            String fileName = userInputReader.readLine();

            File file = new File(fileName);
            if (file.exists()) {
                // Read file contents and send to the client
                BufferedReader fileReader = new BufferedReader(new FileReader(file));
                String line;

                while ((line = fileReader.readLine()) != null) {
                    out.println(line); // Send each line to the client
                }

                System.out.println("The file was sent successfully.");
                fileReader.close();
            } else {
                System.out.println("File does not exist.");
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            // Close all resources
            if (out != null) out.close();
            if (userInputReader != null) userInputReader.close();
            if (clientSocket != null) clientSocket.close();
            if (serverSocket != null) serverSocket.close();
        }
    }
}
