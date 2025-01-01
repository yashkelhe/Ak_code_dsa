package Stack;

import java.util.*;

// this is imortent question  so remember the logic  this question
public class Next_greater_Element {

    public static void main(String[] args) {
        // int arr[] = { 6, 8, 0, 1, 3 };
        int arr[] = { 5, 4, 10, 2, 1, 0, 9, 11 };
        Stack<Integer> s = new Stack<>();
        int nextGreater[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            // while to remove less then value of the in dex and we are going to store our
            // index in the stack

            // This part of the code is a while loop that checks if the stack `s` is not
            // empty and if
            // the element at the top of the stack (retrieved using `s.peek()`) is less than
            // or equal to
            // the current element `arr[i]`. If this condition is true, it pops the element
            // from the
            // stack.
            while (!s.empty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            // if else condition if stack is empty then nextgreater will -1
            // else the reamaining element
            if (s.empty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }
            // push then element
            s.push(i);
        }

        for (int i = 0; i < nextGreater.length; i++) {
            System.out.print(nextGreater[i] + " ");
        }
        System.out.println();

    }
}
