package ArrayList;

import java.util.ArrayList;

public class pairs_Sum {
    public static Boolean findPairs(ArrayList<Integer> list, int target) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int sum = list.get(i) + list.get(j);
                if (target == sum) {
                    System.out.println(list.get(i) + "," + list.get(j));
                    return true;
                }
            }
        }
        return false;
    }

    // it will take a O(n) time complexity
    public static Boolean optimizeApproach(ArrayList<Integer> list, int target) {
        int lp = 0;
        int rp = list.size() - 1;
        while (lp < rp) {
            if (list.get(lp) + list.get(rp) == target) {
                System.out.println(list.get(lp) + "," + list.get(rp));
                return true;
            } else if (list.get(lp) + list.get(rp) < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        // System.out.println(findPairs(list, 5));
        System.out.println(optimizeApproach(list, 5));
    }

}