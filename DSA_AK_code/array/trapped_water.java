package array;

public class trapped_water {
    public static int trappedWater(int height[]) {
        int n = height.length;
        int width = 1;
        int leftMax[] = new int[n];
        // frist one is always maximum for left
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            // privouse and current height will be compare for to get leftMax
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {

            // privouse and current height will be compare for to get leftMax
            // and also here for right max we have to check from the right side s
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int trapped = 0;

        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(rightMax[i], leftMax[i]);
            trapped += (waterLevel - height[i]) * width;
        }
        return trapped;
    }

    public static void main(String[] args) {
        int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        System.out.println(trappedWater(height));

    }
}
