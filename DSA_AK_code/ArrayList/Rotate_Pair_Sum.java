package ArrayList;

import java.util.ArrayList;

// find the target to by denoting  sum of the pair 
public class Rotate_Pair_Sum {

    // we can also do this bu using loops but the complexity will be O( n^2)
    // and the time complexity will be O(n);

    public static Boolean rotateAndSorted(ArrayList<Integer> list, int target) {
        // pivot point
        int bp = -1;
        int n = list.size();
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                bp = i;
                break;
            }
        }

        int rp = bp;// 1
        int lp = bp + 1; // 2

        while (lp != rp) {
            if (list.get(lp) + list.get(rp) == target) {
                System.out.println(list.get(lp) + "," + list.get(rp));
                return true;
            } else if (list.get(lp) + list.get(rp) < target) {
                lp = (lp + 1) % n;
            } else {
                // here we are taking the raminder
                // n + rp - 1 becomes 6 + 0 - 1 = 5, which corresponds to the last index.
                // Applying modulo: (5 % 6) = 5.
                rp = (n + rp - 1) % n;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // the list is sorted and rotated

        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 16;
        rotateAndSorted(list, target);
    }
}
