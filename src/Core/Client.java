package Core;

import Controller.Controller;
import View.LoginView;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static Controller controller;

    public static void main(String[] args) {
        try {
            // Establish connection with the server
            System.out.println("test");
            Socket socket = new Socket("localhost", 9999);
            System.out.println("created socket");
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("created oos");
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            System.out.println("created ois");
            controller = new Controller(socket, ois, oos);

            System.out.println("Created controller");
            LoginView.start();
        } catch (Exception e) {
            System.out.println("In expection " + e.getMessage());
            e.printStackTrace();
        }
    }
}
