package divide_conquer.question;

public class q2 {
    private static int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }

        }
        return count;
    }

    private static int majoritCount(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }
        int mid = lo + (hi - lo) / 2;
        int left = majoritCount(nums, lo, mid);
        int right = majoritCount(nums, mid + 1, hi);

        if (left == right) {
            return left;
        }
        int leftcount = countInRange(nums, left, lo, hi);
        int rightcount = countInRange(nums, right, lo, hi);
        return leftcount > rightcount ? left : right;
    }

    public static int majorityElemetns(int nums[]) {
        return majoritCount(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElemetns(nums));
    }
}

// 1. Initial call: majorityElemetns(nums)
// 2. majoritCount(nums, 0, 6)
// - left = majoritCount(nums, 0, 3)
// - left = 2
// - right = majoritCount(nums, 4, 6)
// - right = 2
// - leftcount = countInRange(nums, 2, 0, 6) // Count occurrences of 2 in the
// entire array
// - returns 5 (2 appears 5 times)
// - rightcount = countInRange(nums, 2, 0, 6) // Count occurrences of 2 in the
// entire array
// - returns 5 (2 appears 5 times)
// - Both left and right are the same (2), so return 2 as the majority element
// for range 0 to 6.
// 3. Returns 2 as the majority element in the entire array.
