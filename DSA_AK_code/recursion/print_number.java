package recursion;

public class print_number {
    // print numbers in ascending order 
    public static void decreasing( int n){
        // base condition 
        if(n ==1 ){
          System.out.println(n);
            return;
        }        // work
        System.out.println(n+ " ");
        // recursive function 
        decreasing(n-1);
    }
    // print numbers in inceasing order 

    public static void inceasing( int n){
        // base condition 
        if(n ==1 ){
          System.out.println(n);
            return;
        }       
        // recursive function 
        inceasing(n-1);
        // work
       System.out.println(n);
    }
    public static void main(String[] args) {
        int n = 10 ;
        decreasing(n);
        System.out.println();
        inceasing(n);

    }
}
