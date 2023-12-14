package OOPS;
//  we cant create a object of abstract class

// we dont implement a abstract class or methods / function
// we implement the function by using subclass class or submethods like 
// and when you make a abstract method or class must have tomake a subclass to implement the function of it
// and we can also make a constructor 
public class abstract_methods {
    public static void main(String[] args) {
        Humman h = new Humman();
        h.walk(2);
        Fish f = new Fish();
        f.eat();
        f.walk(4);

        // constructor

        h.getColor();
        h.changeTheColor("red");
        h.getColor();

        // class constructor in hirarecky
        System.out.println();
        System.out.println("first base class then derived class then again privouse class derived classs");
        Mustange m = new Mustange();
    }
}

abstract class Animal {
    // constructor
    String color;

    // when you extends the Animal class the color will by default will be yellow
    // that the work of this constructor
    // Animal() {
    // color = "yellow";
    // }

    Animal() {
        System.out.println("base class constructor...");
    }

    void eat() {
        System.out.println("animal are eating a food");
    }

    // this is just an idea
    abstract void walk(int a);
}

// subclass
class Humman extends Animal {

    Humman() {
        System.out.println("This is second class constructor...");
    }

    void changeTheColor(String color) {
        this.color = color;
    }

    void getColor() {
        System.out.println("color is " + color);
    }

    void walk(int a) {
        System.out.println("animal are walking on the two legs..." + a);

    }
}

class Mustange extends Humman {
    Mustange() {
        System.out.println("thired class constructor");
    }
}
// subclass

class Fish extends Animal {
    void walk(int a) {
        System.out.println("animal are walking on the 4 legs..." + a);
    }
}