package Hashing;

import java.util.TreeMap;

// it willl sort in the key in  order and we use the red black tree  DSA  in the TreeMap 
public class TreeMap_hashing {
    public static void main(String[] args) {
        TreeMap<Integer, String> hm = new TreeMap<Integer, String>();

        hm.put(1, "india ");
        hm.put(2, "china ");
        hm.put(3, "usa");
        System.out.println(hm);
    }
}
