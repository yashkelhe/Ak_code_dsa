package backtracking.Question;
// You are given a starting position for a rat stuck in a maze at an initial point (0,0) on a 2-dimensional plane. The maze is represented as a square matrix of order N*N, where:

// Cells with value 0 represent the maze's blocked locations.
// Cells with value 1 represent open/available paths that the rat can traverse to reach its destination.
// The rat's destination is at the position (N - 1, N - 1).
// Your task is to find all the possible paths that the rat can take to reach from the source to the destination in the maze. The possible directions the rat can move in the maze are:

// 'U' (up) i.e., (x, y - 1)
// 'D' (down) i.e., (x, y + 1)
// 'L' (left) i.e., (x - 1, y)
// 'R' (right) i.e., (x + 1, y)
// Find and list all the possible paths that the rat can take from the starting point to reach the destination in the maze
public class Rate_in_Maze {
    public static void printMaze(int maze[][]) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean findPath(int maze[][]) {
        int N = maze.length;
        int sol[][] = new int[N][N];
        if (!solveMaze(maze, 0, 0, sol)) {
            System.out.println("No solution exists");
            return false;
        }
        printMaze(sol);
        return true;
    }

    public static boolean solveMaze(int maze[][], int x, int y, int sol[][]) {
        int N = maze.length;
        if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }

        if (isSafe(maze, x, y)) {// cheak the outside condition
            if (sol[x][y] == 1) {// indicates that the rat has already visited this cell
                return false;
            }
            sol[x][y] = 1;

            if (solveMaze(maze, x + 1, y, sol)) {
                return true;
            }
            if (solveMaze(maze, x, y + 1, sol)) {
                return true;
            }
            if (solveMaze(maze, x - 1, y, sol)) {
                return true;
            }
            if (solveMaze(maze, x, y - 1, sol)) {
                return true;
            }

            sol[x][y] = 0;
            return false;
        }
        return false;
    }

    public static boolean isSafe(int maze[][], int x, int y) {
        int N = maze.length;
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    public static void main(String[] args) {
        int maze[][] = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 }
        };
        findPath(maze);
    }
}
