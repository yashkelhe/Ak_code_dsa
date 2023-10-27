package strings;

// here we have to find the sortest distance so here in pysics distance is displacement 
// and formula
// root of (x2 - x1)^2 + (y2 - y1)^2
// here we use one for loop the time complexity will be O(n)

public class sortest_Path {
    public static float sortestPath(String path) {
        int x = 0;
        int y = 0;

        for (int i = 0; i < path.length(); i++) {
            int dir = path.charAt(i);

            // South
            if (dir == 'S') {
                y--;
            }
            // North
            if (dir == 'N') {
                y++;
            }
            // East
            if (dir == 'E') {
                x++;
            }
            // wast
            else {
                x--;
            }
        }
        int x2 = x * x;
        int y2 = y * y;
        return (float) Math.sqrt(x2 + y2);

    }

    public static void main(String[] args) {
        String str = "WNEENESENNN";
        System.out.println(sortestPath(str));

    }
}
