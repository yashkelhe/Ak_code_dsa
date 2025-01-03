package Greedy_Algorithm;

// this is a importent qeuestion and some question can be ask on the chees borad or anything that have cut into pieces
import java.util.*;

// consider a cocolate bar of the n*m;  n= 4 ; m = 6;
public class chocola_problem {
    public static void main(String[] args) {

        Integer costHor[] = { 4, 3, 2, 1, 1 };
        Integer costVer[] = { 4, 2, 1 };
        // sort the arraya in the descending order
        Arrays.sort(costHor, Collections.reverseOrder());
        Arrays.sort(costVer, Collections.reverseOrder());
        // take two pointer that will traverse from the array

        int h = 0;
        int v = 0;

        // here we have considered the horizontal piecess and the vertical piecess as
        // one a big chocolate bar
        int hp = 1;
        int vp = 1;
        int cost = 0;
        // run the loop costHor and costVer length
        while (h < costHor.length && v < costVer.length) {
            // here now we have to make cuts on the chocolate
            if (costVer[v] <= costHor[h]) { /// for the horizontal cuts
                cost += (costHor[h] * vp);
                h++;
                hp++;
            } else { // for the vertical cuts
                cost += (costVer[v] * hp);
                v++;
                vp++;

            }
        }

        // if the any value in the array is remaining then this while loop take care of
        // it

        // These two while loops are necessary to handle the remaining elements in the
        // costHor and costVer arrays if either of them has more elements than the
        // other.

        // For example, consider the scenario where costHor has more elements than
        // costVer. After the first while loop, h has reached costHor.length, but v
        // might still be less than costVer.length. So, we need to go through the
        // remaining elements of costVer and add them to the total cost.
        while (h < costHor.length) {
            cost += costHor[h] * vp;
            h++;
            hp++;

        }
        while (v < costVer.length) {
            cost += costVer[v] * hp;
            v++;
            vp++;
        }

        System.out.println("the minimumm cost is : " + cost);

    }
}
