package backtracking;

public class Sudoku {

    public static Boolean isSafe(int sudoku[][], int row, int col, int digit) {
        // row
        for (int i = 0; i <= 8; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }

        // colume
        for (int i = 0; i <= 8; i++) {
            if (sudoku[row][i] == digit) {
                return false;
            }
        }

        // Grid 3 * 3

        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        System.out.println("sr : "+sr+" sc : "+sc);
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Boolean findSudoku(int sudoku[][], int row, int col) {
        // base
        if (row == 9) {
            // prinSudoku(sudoku);
            return true;
        }
        // recursion
        // for next line
        int newRow = row, newCol = col + 1;

        if (newCol == 9) {
            newRow = row + 1;
            newCol = 0;
        }

        // to check that the number is already present in the index or not

        if (sudoku[row][col] != 0) {
            return findSudoku(sudoku, newRow, newCol);
        }
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if (findSudoku(sudoku, newRow, newCol)) {// solution exists
                    return true;
                }
                // not exists
                sudoku[row][col] = 0;
            }
        }
        return false;
    }

    public static void printSudoko(int sudoku[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int sudoku[][] = { { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
                { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
                { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
                { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
                { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
                { 9, 6, 0, 4, 0, 5, 0, 0, 0 },
                { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
                { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
                { 8, 2, 7, 0, 0, 9, 0, 1, 3 } };

        if (findSudoku(sudoku, 0, 0)) {
            System.out.println("solution exists");
            printSudoko(sudoku);
        } else {
            System.out.println("solution not exists");
        }

    }

}
