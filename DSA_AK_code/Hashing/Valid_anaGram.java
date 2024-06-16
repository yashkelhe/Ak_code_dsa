package Hashing;

import java.util.HashMap;
// TC is O(n)

public class Valid_anaGram {
    public static boolean anaGram(String s, String t) {
        // if the length is not same the return false
        if (s.length() != t.length()) {
            System.out.println("false");
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency of each character in s
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Decrease frequency based on characters in t
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
            } else {
                System.out.println("false");
                return false;
            }
        }

        return map.isEmpty();
    }

    public static void main(String[] args) {
        String s = "knee";
        String t = "keen";
        System.out.println(anaGram(s, t));

    }
}
