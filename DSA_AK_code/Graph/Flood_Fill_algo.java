package Graph;

public class Flood_Fill_algo {
    // O(m * n)
    public void helper(int[][] image, int sr, int sc, int color, boolean[][] visi, int orgCol) {

        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || visi[sr][sc]
                || image[sr][sc] != orgCol) {
            return;
        }

        // Mark the pixel as visited
        // if its visited then dont take again
        visi[sr][sc] = true;

        // Change the color of the current pixel
        image[sr][sc] = color;

        // left
        helper(image, sr, sc - 1, color, visi, orgCol);
        // right
        helper(image, sr, sc + 1, color, visi, orgCol);
        // up
        helper(image, sr - 1, sc, color, visi, orgCol);
        // down
        helper(image, sr + 1, sc, color, visi, orgCol);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visi = new boolean[image.length][image[0].length];
        // the original color will of the color which is sr and sc is on it and change
        // the color which is similar to it with new color
        // and else do not do anything set as its
        helper(image, sr, sc, color, visi, image[sr][sc]);
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {
                { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 }
        };
        int sr = 1; // starting row index
        int sc = 1; // starting column index
        int newColor = 2; // new color to fill

        Flood_Fill_algo floodFillAlgo = new Flood_Fill_algo();
        int[][] result = floodFillAlgo.floodFill(image, sr, sc, newColor);

        System.out.println("Resulting image after flood fill:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
