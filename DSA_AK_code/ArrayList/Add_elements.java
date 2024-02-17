package ArrayList;

import java.util.ArrayList;

public class Add_elements {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // add elements add takes o(1) time complexity
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);

        // add number at index this also takes O(n) time complexity
        // list.add(index_at, new_value)
        list.add(1, 9);
        System.out.println(list);

        // to get the value at index, opeation take O(1) time complexity
        int index = list.get(3);
        System.out.println(index);

        // remove elements take O(n) time complexity
        list.remove(2);
        System.out.println(list);

        // set elements at index O()
        // list.set(index_number, new_value)
        list.set(2, 26);
        System.out.println(list);

        // contains elements if exists then it will give true else false
        System.out.println(list.contains(1));
        System.out.println(list.contains(7));

        // to print the size of the arraylist
        System.out.println("length of the list :" + list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
