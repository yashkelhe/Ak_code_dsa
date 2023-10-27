package arrray_2d_array;

import java.util.Scanner;
// here 2d array  is like matrics 
// n*m matrix 

public class matrices {

    public static void search(int matrix[][], int key) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                // to search the number in the array
                if (matrix[i][j] == key) {
                    System.out.println("found at cell (" + i + "," + j + ")");
                }
                // to get the largest number
                if (matrix[i][j] > largest) {
                    largest = matrix[i][j];
                }

                // to get smallest number
                if (matrix[i][j] < smallest) {
                    smallest = matrix[i][j];
                }

            }

        }
        System.out.println(" the largest number is in array is : " + largest);
        System.out.println(" the smallest number is in array is : " + smallest);

    }

    public static void main(String[] args) {
        int matrix[][] = new int[3][3];
        int n = matrix.length; // this gives row length
        int m = matrix[0].length; // and this gives single row length
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) { // length is 0,1 ,2,
            for (int j = 0; j < m; j++) { // 0,1,2
                matrix[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        search(matrix, 5);
    }
}
