package OOPS;

public class super_keyword {
    public static void main(String[] args) {
        Horse h = new Horse();
        System.out.println(h.color);
    }
}

class Animal {
    String color;

    Animal() {
        System.out.println("Animal");
    }
}

class Horse extends Animal {
    Horse() {
        super.color = "white";
        System.out.println("horse");
    }
}
