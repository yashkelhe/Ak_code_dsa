import java.util.*;

// this take the TC is (n);
// one for loop  take O(n)
// and while also work for the O(1)
public class find_non_Reapeating_letter_in_Stream {

    public static void nonReapeatingChar(String str) {
        // first create a frq array
        int frq[] = new int[26];
        // create a queue
        Queue<Character> q = new LinkedList<>();

        // loop to find a first char and also to cheack wheather its repeated or not
        for (int i = 0; i < str.length(); i++) {
            // take char
            char ch = str.charAt(i);
            // add char in the queue
            q.add(ch);
            // increase the frq in the array char position char - char =int
            frq[ch - 'a']++;

            // to see the char at peek position in the queue is greater then 1 then remove
            while (!q.isEmpty() && frq[q.peek() - 'a'] > 1) {
                q.remove();
            }

            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                // if the value is equal to the 1 then print the peek char
                System.out.print(q.peek() + " ");
            }
        }
    }

    public static void main(String[] args) {
        String str = "aabccxb";
        // String str = "raammar";
        nonReapeatingChar(str);

        // ouput is giving on the each char as the comming as stream and each stream the
        // loop cheacks the nonReapeatingChar character
    }

}
