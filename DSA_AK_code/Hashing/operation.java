package Hashing;

import java.util.HashMap;

public class operation {
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();

        // put operation
        map.put("india", 100);
        map.put("chaina", 139);
        map.put("us", 55);
        map.put("england", 2);
        System.out.println(map);

        // GET operation
        int result = map.get("india");
        System.out.println(result);

        // containsKey("key") => true or false
        System.out.println(map.containsKey("india"));
        System.out.println(map.containsKey("India"));

        // remove operation
        System.out.println(map.remove("chaina"));
        System.out.println(map);

        // size operation
        System.out.println(map.size());

        // isEmpty operation
        System.out.println(map.isEmpty());

        // clear operation
        map.clear();
        System.out.println(map);
    }
}
