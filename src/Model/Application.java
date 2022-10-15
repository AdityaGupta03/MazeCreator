package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Application implements Serializable {
    private ArrayList<Maze> mazes;
    private ArrayList<User> users;

    public Application(ArrayList<Maze> mazes, ArrayList<User> users) {
        this.mazes = mazes;
        this.users = users;
    }

    public ArrayList<Maze> getMazes() {
        return mazes;
    }

    public void setMazes(ArrayList<Maze> mazes) {
        this.mazes = mazes;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
