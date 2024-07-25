package delete;

// Abstract class Animal with a concrete method and an abstract method
abstract class Animal {
    // Concrete method eat
    void eat() {
        System.out.println("something should be here");
    }
    
    // Abstract method run
    abstract void run();
}

// Concrete class LetsRun extending Animal and providing implementation for run
class LetsRun extends Animal {
    // Implementation of the abstract method run
    void run() {
        System.out.println("the way we use the abstract class");
    }
}

// Main class to test the functionality
public class timePass {
    public static void main(String[] args) {
        // Creating an instance of LetsRun
        LetsRun l1 = new LetsRun();
        
        // Calling the eat method
        l1.eat();
        
        // Calling the run method
        l1.run();
    }
}
