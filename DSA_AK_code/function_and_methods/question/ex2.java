package function_and_methods.question;

public class ex2 {
    public static boolean isEven(int n) {
        boolean iseven = true;

        if (n % 2 != 0) {
            iseven = false;
        }
        return iseven;
    }

    public static void main(String[] args) {

        boolean result = isEven(3);
        System.out.println("this is a : " + result);

    }
}
