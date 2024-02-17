package ArrayList.question;

// find the weather a list is monotonic increasing or monotonic decreasing
import java.util.ArrayList;

public class monotonic {

    // here also we wll get the O(n) time complexity
    public static Boolean isMonotoicOptimize(ArrayList<Integer> list) {
        boolean inc = true;
        boolean dec = true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                inc = false;
            } else {
                dec = false;
            }
        }
        if (inc == true) {
            System.out.println("mono inc");
        }
        if (dec == true) {
            System.out.println("mono dec");

        }
        return inc || dec;

    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(4);
        list.add(4);
        list.add(6);
        System.out.println(isMonotoicOptimize(list));
    }
}
