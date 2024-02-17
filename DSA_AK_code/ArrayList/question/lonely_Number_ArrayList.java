package ArrayList.question;
// You are given an integer array list nums. A number x is lonely when it appears only once in the array, and no adjacent numbers (i.e., x + 1 and x - 1) appear in the array list. Return all lonely numbers in nums. The order of the returned numbers does not matter.

// Input:
//     nums = [10, 6, 5, 8]
// Output:
//     [10, 8]
// Explanation:
//     - 10 is a lonely number since it appears exactly once, and 9 and 11 do not appear in nums.
//     - 8 is a lonely number since it appears exactly once, and 7 and 9 do not appear in nums.
//     - 5 is not a lonely number since 6 appears in nums and vice versa.
//     Hence, the lonely numbers in nums are [10, 8]. Note that [8, 10] may also be returned.

// Input:
//     nums = [1, 3, 5, 3]
// Output:
//     [1, 5]
// Explanation:
//     - 1 is a lonely number since it appears exactly once, and 0 and 2 do not appear in nums.
//     - 5 is a lonely number since it appears exactly once, and 4 and 6 do not appear in nums.
//     - 3 is not a lonely number since it appears twice.
//     Hence, the lonely numbers in nums are [1, 5]. Note that [5, 1] may also be returned.
import java.util.*;

public class lonely_Number_ArrayList {
    // time complexity is O( n log n)
    public static ArrayList<Integer> findLonelyNumber(ArrayList<Integer> nums) {
        Collections.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i < nums.size() - 1; i++) {
            if (nums.get(i - 1) + 1 < nums.get(i) && nums.get(i) + 1 < nums.get(i + 1)) {
                list.add(nums.get(i));
            }
        }

        // if list has only one element is remaing in the list
        if (nums.size() == 1) {
            list.add(nums.get(0));
        }
        if (nums.size() > 1) {
            if (nums.get(0) + 1 < nums.get(1)) {
                list.add(nums.get(0));
            }
            if (nums.get(nums.size() - 2) + 1 < nums.get(nums.size() - 1)) {
                list.add(nums.get(nums.size() - 1));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(3);
        list.add(8);
        list.add(10);
        System.out.println(findLonelyNumber(list));
    }
}

// list loop jo first le ga us ke next ko cheack kargeke same hai ky nahi or
// ager nahi then again we will chack that ke uske aage vala koi use value se
// bada hai ky nahi
