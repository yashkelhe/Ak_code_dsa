package recursion.question;

public class q3 {
    public static int findLengthRecursive(String inputString) {
        // Base case: if the string is empty, return 0
        if (inputString.length() == 0) {
            return 0;
        }
        // Recursive case: increment the length by 1 and call the function with the
        // string minus the first character

        return 1 + findLengthRecursive(inputString.substring(1));
    }

    public static void main(String[] args) {
        String name = "yash";
        System.out.println(findLengthRecursive(name));
    }
}

// Initial call: findLengthRecursive("Hello, Recursion!")
// Recursive call 1: findLengthRecursive("ello, Recursion!")
// Recursive call 2: findLengthRecursive("llo, Recursion!")
// Recursive call 3: findLengthRecursive("lo, Recursion!")
// Recursive call 4: findLengthRecursive("o, Recursion!")
// Recursive call 5: findLengthRecursive(", Recursion!")
// Recursive call 6: findLengthRecursive(" Recursion!")
// Recursive call 7: findLengthRecursive("Recursion!")
// Recursive call 8: findLengthRecursive("ecursion!")
// Recursive call 9: findLengthRecursive("cursion!")
// Recursive call 10: findLengthRecursive("ursion!")
// Recursive call 11: findLengthRecursive("rsion!")
// Recursive call 12: findLengthRecursive("sion!")
// Recursive call 13: findLengthRecursive("ion!")
// Recursive call 14: findLengthRecursive("on!")
// Recursive call 15: findLengthRecursive("n!")
// Recursive call 16: findLengthRecursive("!")
// Base case reached: return 0
// Then, as the function returns from each call, it adds 1 for each level of the
// recursion until it reaches the initial call. The call stack gradually
// unwinds, incrementing the count by 1 at each step until it reaches the
// initial call, giving the final length of the string