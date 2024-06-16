package Hashing;

import java.util.LinkedHashMap;

// LinkedHashMap always give the order which we will provide the input to the LinkedHashMap 
// and some will be the output
public abstract class linkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> hm = new LinkedHashMap<Integer, String>();

        hm.put(1, "india");
        hm.put(4, "landon");
        hm.put(2, "china");
        hm.put(5, "america");
        hm.put(3, "usa");
        System.out.println(hm);
    }
}
