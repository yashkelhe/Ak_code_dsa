package recursion;

public class sumOfNaturlNumbers {
    public static int sum(int n) {
        // base case
        if (n == 1) {
            return 1;
        }

        // here we are calculating the sum of n-1 numbers like when first 5 comes for 5
        // function will calculate the sum of n-1 numberss then goes as on until it
        // reaches to the n==1
        int cal = sum(n - 1);
        // then we will just add the sum of privouse numbers to the current number then
        // we will get the sum of n natural numbers
        // so privouse sum will be 10
        int sum = n + cal;
        return sum;
    }

    public static void main(String[] args) {
        int n = 5;

        System.out.println(sum(n));
    }
}

// 5 4 3 2 1

// 5 +1 =6
// 6 + 2 = 8
// 8 + 3 = 11
// 11+ 4 + 15
