package ArrayList;

import java.util.ArrayList;

public class Most_Water_Contain {
    // brute force O(n^2)
    public static int waterMost(ArrayList<Integer> list) {
        int mostWater = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                int height = Math.min(list.get(i), list.get(j));
                int width = j - i;
                int water = height * width;
                mostWater = Math.max(mostWater, water);
            }
        }
        return mostWater;
    }

    // optimize approach and time complexity will be O(n);
    // becouse it only running at linear time means both pointer comes at middle
    // using "2 pointers approach"
    public static int opptimizeApproach(ArrayList<Integer> list) {
        int maxValue = 0;
        int lp = 0;
        int rp = list.size() - 1;
        while (lp < rp) {
            int height = Math.min(list.get(lp), list.get(rp));
            int width = rp - lp;
            int currentWater = height * width;
            maxValue = Math.max(maxValue, currentWater);
            if (list.get(lp) < list.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {

        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(opptimizeApproach(height));
        // System.out.println(waterMost(height));

    }
}