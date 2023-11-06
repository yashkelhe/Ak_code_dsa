package getters_setters;

public class Inheritance {
    public static void main(String[] args) {
        Fish shark = new Fish();
        shark.swim();
        shark.eat();
        shark.breath();

    }
}

class Animal {
    String color;

    void eat() {
        System.out.println("eating");
    }

    void breath() {

        System.out.println("yes i am breathing...!");
    }
}

class Fish extends Animal {
    int fins;

    void swim() {
        System.out.println("hoouu ree, i am swing ...!");
    }
}