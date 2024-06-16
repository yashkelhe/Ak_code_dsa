package Hashing;

import java.util.*;

public class HashSet_hashing {
    public static void main(String[] args) {

        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        // it will take the TC is O(1)
        System.out.println(set);
        System.out.println(set.remove(3));
        System.out.println("set containss 3 : " + set.contains(3));
        System.out.println(set.size());
        set.clear();
        System.out.println(set.size());
        System.out.println(" the set is " + set.isEmpty());
    }

}
