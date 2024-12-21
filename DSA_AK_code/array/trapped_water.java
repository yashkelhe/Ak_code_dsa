package array;

public class trapped_water {
    public static void printArray(int[] numbers) {
        System.out.print("Array elements: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println(); // for new line
    }

    public static int trappedWater(int height[]) {
        // length of the array
        int n = height.length;
        int width = 1;
        int leftMax[] = new int[n];

        // 4
        leftMax[0] = height[0];
        // O(n)
        for (int i = 1; i < n; i++) {

            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        // the leftMax Will be {4 4 4 6 6 6 6 }
        // the RightMax Will be {6 6 6 6 5 5 5 }
        // { 4, 2, 0, 6, 3, 2, 5 };

        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];
        // O(n)
        for (int i = n - 2; i >= 0; i--) {
            // i + 1 is for beacouse we are starting from the end
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int trapped = 0;
        // O(n)
        for (int i = 0; i < n; i++) {
            // take minimum one why because we want to claculate the trapped water
            int waterLevel = Math.min(rightMax[i], leftMax[i]);
            trapped += (waterLevel - height[i]) * width;
        }

        printArray(leftMax);
        printArray(rightMax);
        return trapped;
    }

    public static void main(String[] args) {
        // width = 1
        // area = height * width
        int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        // O(n)+O(n)+O(n) =(3n)=(n)
        System.out.println(trappedWater(height));

    }
}
