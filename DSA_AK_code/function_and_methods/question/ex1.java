package function_and_methods.question;

//Write a Java method to compute the averageof three numbers
public class ex1 {
    public static int average(int a, int b, int c) {
        return (a + b + b) / 3;
    }

    public static void main(String[] args) {
        int a = 7;
        int b = 7;
        int c = 7;
        int result = average(a, b, c);
        System.out.println(result);
    }
}
