package OOPS;
// in this constructor there  are two types like when you make changes in the s1 and that also reflect on the s2 also then its shallow copy means its change by reference 

//  deep copy means when you make changes int the s1 and that doesn't reflect on the s2 then its called deep copy 
// in thiss we copy each element 
public class copy_constructor {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = " yash";
        s1.roll = 100;
        s1.markes[0] = 1;
        s1.markes[1] = 10;
        s1.markes[2] = 100;

        Student s2 = new Student(s1);
        s1.markes[0] = 100;

        for (int i = 0; i <= 2; i++) {
            System.out.println(s2.markes[i]);
        }

    }
}

class Student {
    String name;
    int roll;
    int markes[];

    // shallow copy
    // Student(Student s1) {
    // this.markes = s1.markes;
    // this.name = s1.name;
    // this.roll = roll;
    // }

    // this is a deep copy which every element is copied
    Student(Student s1) {
        markes = new int[3];
        this.name = s1.name;
        this.roll = roll;
        for (int i = 0; i <= 2; i++) {
            // here every element is copied
            this.markes[i] = s1.markes[i];
        }
    }

    Student() {
        markes = new int[3];
        System.out.println("hello this is a constructor ...!");
    }

    Student(String name) {
        markes = new int[3];
        this.name = name;
    }

    Student(int number) {
        markes = new int[3];
        System.out.println("this is a constructor " + number);
    }
}