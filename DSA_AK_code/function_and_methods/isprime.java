package function_and_methods;

// public class isprime {
//     public static boolean ispri(int a) {
//         boolean ispr = true;
//         for (int i = 2; i <= a; i++) {
//             if (a % i == 0) {
//                 return ispr = false;
//             }
//         }
//         return ispr;
// }

public class isprime {
    public static boolean ispri(int a) {
        boolean ispr = true;
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                return ispr = false;
            }
        }
        return ispr;
    }

    public static void main(String[] args) {
        System.out.println(ispri(7));
    }
}
