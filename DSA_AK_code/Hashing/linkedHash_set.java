package Hashing;

import java.util.*;

// here as we have insert the element the order will be maintained by the LinkedHashSet
public class linkedHash_set {
    public static void main(String[] args) {

        LinkedHashSet<String> set = new LinkedHashSet<>();

        set.add("india");
        set.add("china");
        set.add("us");
        set.add("landon");

        System.out.println(set);
    }
}
