package array.assignment;

import java.util.*;
// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct

// {1 ,2 ,3,1}
// here we can use hashset to check uniqueness of in the array 

public class question1 {
    public static boolean isDistinct(int[] nums) {
        Set<Integer> distinct = new HashSet<Integer>();
        for (int elements : nums) {
            if (distinct.contains(elements)) {
                System.out.println("True");
                return true;
            }
            distinct.add(elements);
        }
        System.out.println("False");
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 2 };
        boolean isdistinct = isDistinct(arr);

    }
}
