package Model;

public class Maze {

    private int size;
    private int[][] maze;

    public Maze(int size) {
        this.size = size;
        this.maze = new int[size][size];
    }

    private void createMaze() {
        // Create a maze using either DFS or MST
    }

}
