package array;

// -ve = 0
public class KADANES {
    public static void kadanes(int numbers[]) {
        int ms = Integer.MIN_VALUE;
        int cs = 0;
        int ifnve = 0;

        // to check all the elements are negative or not if yes the
        /*
         * if the numbers is negative then compare with the priviouse negative number
         * and then print smallest one
         */

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] < 0 && numbers[i] < ifnve) {
                ifnve = numbers[i];
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            cs = cs + numbers[i];
            if (cs < 0) {
                cs = 0;
            }
            ms = Math.max(cs, ms);
        }
        System.out.println("maximum sum of subarray is :" + ms);
        System.out.println("maximum sum of subarray is :" + ifnve);
    }

    public static void main(String[] args) {
        int numbers[] = { -12, -33, -4 };
        kadanes(numbers);

    }
}