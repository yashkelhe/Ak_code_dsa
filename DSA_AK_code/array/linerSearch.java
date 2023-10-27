package array;

public class linerSearch {
    public static int linersearch(int number[], int key) {
        for (int i = 0; i <= number.length; i++) {
            if (number[i] == key) {

                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int number[] = { 1, 2, 3, 4, 5, 6 };
        int key = 3;
        int index = linersearch(number, key);
        if (index == -1) {
            System.out.println("not found");

        } else {
            System.out.println("the number at index of " + index);
        }

    }
}
