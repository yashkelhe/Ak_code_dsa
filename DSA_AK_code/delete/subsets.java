package delete;

public class subsets {
    public static void sub(String sc) {
        for (int i = 0; i < sc.length(); i++) {
            for (int j = i; j < sc.length(); j++) {
                for (int l = i; l <= j; l++) {

                    System.out.print(sc.charAt(l));
                }
                System.out.println();
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        String sc = "abc";
        sub(sc);
    }
}
