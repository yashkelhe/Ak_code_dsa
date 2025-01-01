package Stack;

import java.util.*;

// time complexity is three time linear its means TC is O(n)
public class Max_area_Histogram {
    public static void maxArea(int arr[]) {
        int maxAr = 0;
        int nsmallRight[] = new int[arr.length];
        int nsmalleft[] = new int[arr.length];

        Stack<Integer> s = new Stack<>();

        // to find the next smallest right O(n)
        for (int i = arr.length - 1; i >= 0; i--) {
            //
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {

                // if the next smallest rig7ht is not present then we will take the length of
                // the
                nsmallRight[i] = arr.length;
            } else {
                nsmallRight[i] = s.peek();
            }
            s.push(i);
        }
        printArr(nsmallRight);

        // stack already created we are just making them as empty
        s = new Stack<>();
        // to find the next smallest left O(n)
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsmalleft[i] = -1;
            } else {
                nsmalleft[i] = s.peek();
            }
            s.push(i);
        }
        printArr(nsmalleft);

        // now find the current area O(n)
        // width = j - i - 1 = nsmalRight[i] - nsmalleft[i] -1;
        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = nsmallRight[i] - nsmalleft[i] - 1;
            int currentArea = height * width;
            maxAr = Math.max(currentArea, maxAr);
            System.out.println("current area is :- " + currentArea);
        }
        System.out.println("maximum area of histogram is :- " + maxAr);
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 2, 1, 5, 6, 2, 3 };
        maxArea(arr);
    }

}
