package Stack;

import java.util.*;

public class Stock_Span_Problem {
    public static void stockSpan(int[] stocks, int[] span) {
        // first create a stack
        Stack<Integer> s = new Stack<>();
        // first we create a stack and asign the last span as the 1 and
        span[0] = 1;
        s.push(0);
        // and then push that in the stack
        for (int i = 1; i < span.length; i++) {
            // calculate the current price
            int currentPrice = stocks[i];
            // if the current price is greater then the previouse value then just pop the
            // element until the then any condition becomes true
            while (!s.isEmpty() && currentPrice > stocks[s.peek()]) {
                s.pop();
            }
            // here we are cheackin that is our stack is becomes a empty or not if yes then
            // just add the 1 in the stack
            // which is last condition for to find the span
            if (s.isEmpty()) {
                span[i] = i + 1;

            }
            // if stack is not empty then find the previous value nd then minuse from the
            // index we will get the span
            else {
                int privouseHigh = s.peek();
                span[i] = i - privouseHigh;
            }

            s.push(i);
        }

    }

    public static void main(String[] args) {
        int[] stocks = { 100, 80, 60, 70, 60, 85, 100 };
        int span[] = new int[stocks.length];

        stockSpan(stocks, span);
        for (int i = 0; i < stocks.length; i++) {
            System.out.println(span[i]);
        }

    }
}
