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
                return true;
            }
            distinct.add(elements);
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        boolean isdistinct = isDistinct(arr);
        if (isdistinct == false) {
            System.out.println("every elements are distinct");
        } else {
            System.out.println("the array is not distinct");
        }

    }
}
