package ArrayList;

import java.util.*;

public class Multi_dimensional {
    public static void main(String[] args) {
        // ArrayList inside the ArrayList
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        // create another ArrayList
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            list1.add(i * 1);
            list2.add(i * 2);
            list3.add(i * 3);
        }
        list.add(list1);
        list.add(list2);
        list.add(list3);
        System.out.println(list);
        System.out.println(list.get(0).get(1));

        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> temp = list.get(i);
            for (int j = 0; j < temp.size(); j++) {
                System.out.print(temp.get(j) + " ");
            }
        }
    }

}