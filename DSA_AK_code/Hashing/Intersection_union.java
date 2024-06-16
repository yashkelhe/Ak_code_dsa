package Hashing;

import java.util.*;

public class Intersection_union {
    public static void union(int arr1[], int arr2[]) {
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        for (Integer x : set) {
            System.out.println(x);

        }
        System.out.println("union is" + set.size());

    }

    public static void intersection(int arr1[], int arr2[]) {
        HashSet<Integer> set = new HashSet<Integer>();
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(arr2[i])) {
                count++;
                System.out.println(arr2[i]);
                set.remove(arr2[i]);
            }
        }
        System.out.println("intersection is = " + count);
    }

    public static void main(String[] args) {
        int arr1[] = { 7, 3, 9 };
        int arr2[] = { 6, 3, 9, 2, 9, 4 };
        union(arr1, arr2);
        System.out.println();
        intersection(arr1, arr2);
    }
}
