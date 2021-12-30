package Controller;

import Model.Request;
import Model.Response;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Controller {
    private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    public Controller(Socket socket, ObjectInputStream ois, ObjectOutputStream oos) {
        this.socket = socket;
        this.ois = ois;
        this.oos = oos;
    }

    public boolean sendRequest(Request request) {
        try {
            this.oos.writeObject(request);
            this.oos.flush();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Response receiveResponse() {
        try {
            Object obj = null;
            while (obj == null) {
                obj = this.ois.readObject();
            }
            return (Response) obj;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean login(String username, String password) {
        String[] parameters = {username, password};
        Request request = new Request("login", parameters);
        boolean writeSuccess = this.sendRequest(request);
        if (!writeSuccess)
            return false;
        Response severResponse = this.receiveResponse();
        if (severResponse == null)
            return false;
        if (severResponse.isError()) {
            System.out.println(severResponse.getErrorMessage());
        }
        return true;
    }

    public boolean signup(String name, String username, String password) {
        String[] parameters = {name, username, password};
        Request request = new Request("signup", parameters);
        return true;
    }
}
