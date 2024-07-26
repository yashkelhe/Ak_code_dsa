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

        // here we use the loop becouse we want to iterate over the colums also for that we use the for loop
        //  and  the is=nside that we have again call the nQueen function that will incrment the row  
        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 'Q';
                nQueen(board, row + 1);// to call the next row
                board[row][i] = 'x';// backtraking step and remove the queent and try to set the queen in differnt places 
            }
        }
    }

    static int count = 0;

    // to cheak the condition of the queen
    public static Boolean isSafe(char board[][], int row, int col) {
//        This loop checks all rows above the current row in the same column.
// If any cell (i, col) contains a queen ('Q'), it returns false, indicating the position is not safe.
        System.out.println("row is : "+row +" col is  : " +col );
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // diagonal left
//      This loop checks all cells in the upper left diagonal from the current position.
// If any cell (i, j) contains a queen ('Q'), it returns false, indicating the position is not safe.
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // diagonal right
//         This loop checks all cells in the upper left diagonal from the current position.
// If any cell (i, j) contains a queen ('Q'), it returns false, indicating the position is not safe.
// why plus one because we have check for the next column 
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
