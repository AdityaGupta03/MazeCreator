package User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            // Establish the server socket
            ServerSocket serverSocket = new ServerSocket(9999);

            while (true) {
                Socket clientSocket = serverSocket.accept();

                // Establish the streams
                ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
