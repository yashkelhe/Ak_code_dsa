package getters_setters;

//  constructor have same name as class name
//  constructor dont have any return type ( not even void also )

public class constructor {
    public static void main(String[] args) {
        Student stt = new Student();
        // System.out.println(stt.name);
    }
}

class Student {
    String name;

    Student() {
        System.out.println("hello this is a constructor ...!");
    }

    Student(String name) {
        this.name = name;
    }

    Student(int number) {
        System.out.println("this is a constructor " + number);
    }
}
