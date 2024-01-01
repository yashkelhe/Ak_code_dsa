package recursion.question;

// TOWER OF HANOI(Important!)
// You have three towers labeled 'A', 'B', and 'C', and a set of 'N' disks of different sizes placed on tower 'A' in ascending order, with the smallest disk on top and larger disks below. The objective is to move the entire stack of disks from tower 'A' to tower 'C', obeying the following rules:

// Only one disk can be moved at a time.
// A disk can be placed either on an empty tower or on top of a larger disk.
// A larger disk cannot be placed on top of a smaller disk.
// Write a program to solve the Tower of Hanoi problem using stacks, considering 'A' as the source tower, 'B' as the auxiliary tower, and 'C' as the destination tower.

// For example, with 'N = 2':
// Step 1: Move the first disk from 'A' to 'B'.
// Step 2: Move the second disk from 'A' to 'C'.
// Step 3: Move the first disk from 'B' to 'C'.

// And with 'N = 3':
// Step 1: Move the first disk from 'A' to 'C'.
// Step 2: Move the second disk from 'A' to 'B'.
// Step 3: Move the first disk from 'C' to 'B'.
// Step 4: Move the third disk from 'A' to 'C'.
// Step 5: Move the first disk from 'B' to 'A'.
// Step 6: Move the second disk from 'B' to 'C'.
// Step 7: Move the first disk from 'A' to 'C'."
public class q5 {
    public static void towerOfHanoi(int n, String src, String helper, String dest) {
        if (n == 1) {
            System.out.println("Transfer disk " + n + " from " + src + " to " + dest);
            return;
        }
        // Move top n-1 disks from src to helper using dest as 'helper'
        towerOfHanoi(n - 1, src, dest, helper);
        // Move nth disk from src to dest
        System.out.println("Transfer disk " + n + " from " + src + " to " + helper);
        // Move n-1 disks from helper to dest using src as 'helper'
        towerOfHanoi(n - 1, helper, src, dest);
    }

    public static void main(String[] args) {
        int n = 3;
        towerOfHanoi(n, "A", "B", "C");
    }

}
