package getters_setters;

public class get_set {
    public static void main(String[] args) {
        // first make an object
        pen p = new pen();
        p.settip(5);
        System.out.println(p.gettip());

        p.setColor("blue");
        System.out.println(p.getColor());

    }
}

// getter return the value
// while setters set the value
// this are used for the private parameters

class pen {
    private String color;
    private int tip;

    // getter method
    int gettip() {
        return this.tip;
    }

    void settip(int tip) {
        this.tip = tip;
    }

    String getColor() {
        return this.color;
    }

    void setColor(String color) {
        this.color = color;
    }
}