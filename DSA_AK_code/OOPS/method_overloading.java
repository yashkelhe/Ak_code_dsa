package getters_setters;

public class method_overloading {
    public static void main(String[] args) {
        calculator cal = new calculator();
        System.out.println(cal.sum(3, 5));
        System.out.println(cal.sum(3.0f, 5.7f));
        System.out.println(cal.sum(3, 5, 92));
        System.out.println(cal.sum(3, 5, 92, 28));
    }
}

class calculator {
    int sum(int a, int b) {
        return a + b;
    }

    float sum(float a, float b) {
        return a + b;
    }

    int sum(int a, int b, int c) {
        return a + b + c;
    }

    int sum(int a, int b, int c, int d) {
        return a + b + c + d;
    }
}
