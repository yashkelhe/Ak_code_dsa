package ArrayList;

import java.util.*;

public class Find_Maximum_Sort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // add elements add takes o(1) time complexity
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);
        int maximum = Integer.MIN_VALUE;// -infinity
        for (int i = 0; i < list.size(); i++) {
            // if (maximum <= list.get(i)) {
            // maximum = list.get(i);
            // }
            maximum = Math.max(maximum, list.get(i));
        }
        System.out.println(maximum);
        System.out.println(list);

        // swaping
        // swap(list, 1, 3);

        // but in the java we have optimize sorting finction
        Collections.sort(list);// it will sort the elements in the ascending order
        System.out.println("ascending order: " + list);

        // now if we want our list in descending order then we will use the comparator
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("descending order : " + list);
    }

    public static void swap(ArrayList<Integer> list, int index1, int index2) {
        int temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);

    }
}
