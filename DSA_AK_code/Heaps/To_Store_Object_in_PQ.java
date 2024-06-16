package Heaps;

import java.util.*;

public class To_Store_Object_in_PQ {

    // Defining a static nested class Student
    static class Student implements Comparable<Student> {
        String name; // Name of the student
        int rank; // Rank of the student

        // Constructor to initialize name and rank of a student
        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        // Implementing the compareTo method of the Comparable interface
        // This method compares the ranks of two students
        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }

    // Main method
    public static void main(String[] args) {
        // Creating a PriorityQueue of type Student
        PriorityQueue<Student> pq = new PriorityQueue<>();

        // Adding students to the PriorityQueue
        pq.add(new Student("yash", 24));
        pq.add(new Student("rohan", 2));
        pq.add(new Student("vinayak", 244));
        pq.add(new Student("raj", 64));

        // Removing and printing students with the lowest rank until the PriorityQueue
        // is empty
        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name + " -> " + pq.peek().rank); // Printing the name and rank of the student
                                                                          // at the front of the PriorityQueue
            pq.remove();
        }
    }
}

// PriorityQueue: It's a data structure that maintains a priority queue.
// Elements are removed from the queue based on their priority. In this case,
// the priority is defined by the compareTo method in the Student class.

// Comparable Interface: The Student class implements the Comparable interface,
// which requires the implementation of the compareTo method. This method
// defines how two Student objects should be compared based on their ranks.

// Nested Class: The Student class is defined as a static nested class within
// the To_Store_Object_in_PQ class. This is a design choice and makes sense if
// Student is tightly coupled with To_Store_Object_in_PQ.

// Main Method: The main method demonstrates the usage of the PriorityQueue. It
// creates a PriorityQueue of Student objects, adds some students, and then
// prints them in the order of their ranks.

// Output Order: The output of the program will display the students' names
// along with their ranks in ascending order because PriorityQueue orders
// elements based on their natural ordering or a custom comparator if provided.

// and also we can use this comparable interface to any data structure