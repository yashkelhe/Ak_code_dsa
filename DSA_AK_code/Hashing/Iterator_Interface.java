package Hashing;

import java.util.*;
// hashSet will give you the unorder set 

public class Iterator_Interface {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("india");
        set.add("china");
        set.add("us");
        set.add("landon");

        // to implement the Interface
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println();

        // we can do this also
        for (String s : set) {
            System.out.println(s);
        }

    }
}
