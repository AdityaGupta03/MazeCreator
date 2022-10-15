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
            Socket socket = new Socket("localhost", 9999);

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            controller = new Controller(socket, ois, oos);

            LoginView.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
