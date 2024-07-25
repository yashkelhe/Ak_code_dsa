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
                if(start == 0){
                    sum = prifix[end];
                }else{
                    sum =  prifix[end] - prifix[start - 1];
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

    }
}
