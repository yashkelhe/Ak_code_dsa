package OOPS.question;

// Print the sum,difference and product of two complex numbers by creating a class named 'Complex' with separate methods for each operation whose real and imaginary parts are entered by the user

public class q1 {
    public static void main(String[] args) {
        Complex c = new Complex(4, 5);
        Complex d = new Complex(9, 4);

        // Perform addition, subtraction, and multiplication of complex number
        Complex e = Complex.add(c, d);
        Complex f = Complex.diff(c, d);
        Complex g = Complex.product(c, d);

        // Print the results
        e.printComplex();
        f.printComplex();
        g.printComplex();
    }
}

class Complex {
    int real;
    int imag;

    // Constructor to create a Complex object with real and imaginary parts
    public Complex(int r, int i) {
        real = r;
        imag = i;
    }

    // Static method to add two Complex numbers
    public static Complex add(Complex a, Complex b) {
        // Create a new Complex object with the sum of real and imaginary parts
        return new Complex((a.real + b.real), (a.imag + b.imag));
    }

    // Static method to subtract two Complex numbers
    public static Complex diff(Complex a, Complex b) {
        // Create a new Complex object with the difference of real and imaginary parts
        return new Complex((a.real - b.real), (a.imag - b.imag));
    }

    // Static method to multiply two Complex numbers
    public static Complex product(Complex a, Complex b) {
        // Create a new Complex object with the product of the numbers
        return new Complex(((a.real * b.real) - (a.imag * b.imag)), ((a.real * b.imag) + (a.imag * b.real)));
    }

    // Method to print the Complex number in a user-friendly format
    public void printComplex() {
        if (real == 0 && imag != 0) {
            System.out.println(imag + "i");
        } else if (imag == 0 && real != 0) {
            System.out.println(real);
        } else {
            System.out.println(real + "+" + imag + "i");
        }
    }
}
