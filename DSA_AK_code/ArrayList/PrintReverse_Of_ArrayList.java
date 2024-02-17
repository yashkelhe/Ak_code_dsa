package ArrayList;

import java.util.ArrayList;

public class PrintReverse_Of_ArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        int length = list.size();
        // time complexity is O(n)
        for (int i = 0; i < length / 2; i++) {
            int temp = list.get(i);
            list.set(i, list.get(length - 1 - i));
            list.set(length - 1 - i, temp);
        }
        System.out.println(list);
    }
}