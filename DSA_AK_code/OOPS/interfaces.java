package OOPS;

public class interfaces {
    public static void main(String[] args) {
        Queen c = new Queen();
        c.moves();
        System.out.println(c.markes(9));

        Rook r = new Rook();
        r.moves();
        poon v = new poon();
        v.moves();
    }
}

// interface
interface chessPlayer {
    void moves();

}

interface person {
    int markes(int a);
}

class Queen implements chessPlayer, person {

    // All the Interface method should be public while implementing
    public void moves() {
        System.out.println("up down left right diagonal");
    }

    public int markes(int a) {
        return a + a;
    }

}

class Rook implements chessPlayer {
    // All the Interface method should be public while implementing
    public void moves() {
        System.out.println("up down left right ");
    }
}

class poon implements chessPlayer {
    // All the Interface method should be public while implementing
    public void moves() {
        System.out.println("up Diagonal");
    }
}