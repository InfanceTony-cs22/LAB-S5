import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
            ServerSocket ss = new ServerSocket(2100);
                    Socket s = ss.accept();
                            DataInputStream in = new DataInputStream(s.getInputStream());
                                    DataOutputStream out = new DataOutputStream(s.getOutputStream());
                                            String msg = in.readUTF();
                                                    System.out.println("Message from client: " + msg);
                                                            out.writeUTF(msg);                                                            
                                                        }
                                                                }