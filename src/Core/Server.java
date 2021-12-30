package Core;

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
                System.out.println("New Connection");

                // Establish the user thread
                UserThread userThread = new UserThread(clientSocket);
                new Thread(userThread).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class UserThread implements Runnable {
        private Socket clientSocket;

        public UserThread(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        public void run() {
            try {
                ObjectInputStream ois = new ObjectInputStream(this.clientSocket.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(this.clientSocket.getOutputStream());
                oos.flush();
                while (true) {
                    String clientInput = (String) ois.readObject();
                }
            } catch (Exception e) {
                System.out.println("Failed user thread.");
            }
        }
    }
}
