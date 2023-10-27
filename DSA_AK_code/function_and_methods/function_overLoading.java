package function_and_methods;

public class function_overLoading {

    public static int sum(int a, float b) {
        return (int) (a + b);
    }

    public static int sum(int a, int b, float c) {
        return (int) (a + b + c);
    }

    public static void main(String[] args) {
        System.out.println(sum(8, 9));
        System.out.println(sum(8, 9, 5));
    }
}