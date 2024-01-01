package backtracking;

public class Nqueen {

    public static void nQueen(char board[][], int row) {
        // base
        if (row == board.length) {
            printBoard(board);

            // to count the number of ways to solve the N Queen
            count++;
            return;
        }
        // recursion

        // column loop
        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 'Q';
                nQueen(board, row + 1);// to call the next row
                board[row][i] = 'x';// backtraking step
            }
        }
    }

    static int count = 0;

    // to cheak the condition of the queen
    public static Boolean isSafe(char board[][], int row, int col) {
        // up direction
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // diagonal left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // diagonal right
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void printBoard(char[][] board) {
        System.out.println("--------chess Board---------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        char board[][] = new char[n][n];
        // initialize the board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'x';
            }
        }
        // all solution
        nQueen(board, 0);

        // count
        System.out.println("total way to solve N queen  is = " + count);
    }
}
