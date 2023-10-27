package array;

public class pairs_array {
    public static void pairs(int num[]) {
        int tp = 0;

        for (int i = 0; i < num.length; i++) {
            int curr = num[i];
            for (int j = i + 1; j < num.length; j++) {
                System.out.print("(" + curr + "," + num[j] + ")");
                tp++;
            }
            System.out.println();
        }
        System.out.println("total numbers of pairs are " + tp);
    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 4, 5, 66, 7, 8 };
        pairs(arr);
    }
}
