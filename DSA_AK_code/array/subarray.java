package array;
// subarray sum of the subarray

public class subarray {
    public static void subaray(int numbers[]) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = i; j < numbers.length; j++) {
                int end = j;
                sum = 0;
                for (int k = start; k <= end; k++) {
                    sum += numbers[k];
                    System.out.print(numbers[k] + " ");

                }

                if (max < sum) {
                    max = sum;

                }
                System.out.println("sum is ; " + max);
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("the maximum value of pair is :" + max);
    }

    public static void main(String[] args) {
        int numbe[] = { 1, 2, 3, 4, 9 };
        subaray(numbe);

    }
}
