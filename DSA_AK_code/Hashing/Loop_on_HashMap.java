package Hashing;

import java.util.*;

public class Loop_on_HashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put(null, null);
        map.put("india", 12);
        map.put("china", 2);
        map.put("us", 222);
        map.put("englan", 23);

        // Iterate
        Set<String> keys = map.keySet();
        System.out.println(keys);

        for (String k : keys) {
            System.out.println("keys = " + k + ", value = " + map.get(k));
        }

        // enteySet() it will return the pairs
        System.out.println("this is a entry set =" + map.entrySet());
    }
}
