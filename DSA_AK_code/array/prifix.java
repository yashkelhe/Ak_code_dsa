package array;
// subarray sum of the subarray

public class prifix {

    // in the prifix = prifix[i-1] + arr[i];
    // prifix is a new array which store the nummbers and

    public static void subaray(int numbers[]) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int prifix[] = new int[numbers.length];

        // make loop to calculate the prifix
        prifix[0] = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            // first all elments of sum and current element of sum
            prifix[i] = prifix[i - 1] + numbers[i];
        }

        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = i; j < numbers.length; j++) {
                int end = j;
                // if i= 0
                // 0,1,2,3,4 ...
                // all values also
                // sum = start == 0 ? prifix[end] : prifix[end] - prifix[start - 1];
                if (start == 0) {

                    // and here the range is from the 0 to n
                    sum = prifix[end];
                } else {

                    // Subtracting prifix[0] removes this extra part, leaving the sum of elements
                    // from start = 1 to end = 2
                    // to get the prefix sum we are just removing the previouse part to get the
                    // current rage of the part
                    sum = prifix[end] - prifix[start - 1];
                }
                if (max < sum) {
                    max = sum;
                }
            }

        }
        System.out.println("the maximum value of single  pair is :" + max);
    }

    public static void main(String[] args) {
        int numbe[] = { 3, -3, 4, 5, -7 };
        subaray(numbe);

        // prefix sum array
        // 3 , 0 , 4 , 9, 2
        // and the max value of the single pair is 9 = 4 + 5

    }
}
