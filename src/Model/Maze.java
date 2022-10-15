package Model;

public class Maze {

    private int size;
    private int[][] maze;

    public Maze(int size) {
        this.size = size;
        this.maze = new int[size][size];
    }

    public Maze(int size, int[][] maze) throws Exception {
        if (size != maze.length) throw new Exception();
        for (int[] ints : maze) {
            if (size != ints.length) throw new Exception();
        }
        this.size = size;
        this.maze = maze;
    }

    private void createMaze() {
        // Create a maze using either DFS or MST
    }

    private int[][] getMaze() {
        return this.maze;
    }

    public String toString() {
        return null;
    }

    public static void main(String[] args) {
        int size = 10;
        Maze maze = new Maze(10);
        maze.createMaze();
        int[][] graph = maze.getMaze();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                switch (graph[i][j]) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    default:
                        break;
                }
                System.out.print("\n");
            }
        }
    }

}
