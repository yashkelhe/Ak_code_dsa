package delete;

import java.util.*;

public class Count_hourse {
    public static int countHourse(int arr[], int hours) {
        HashMap<Integer, Integer> mm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            mm.put(arr[i], i);
        }
        int theHourse = 0;
        int i = 0;
        for (int num : arr) {
            int remaining = hours - num;
            if (mm.containsKey(remaining) && mm.get(remaining) != i) {
                theHourse = theHourse + 1;
            }
            i++;
        }
        return theHourse;
    }

    public static void main(String[] args) {

        int arr[] = { 2, 2, 58, 60, 60 };
        System.out.println("the number of hourse will be : " + countHourse(arr, 60));
    }
}