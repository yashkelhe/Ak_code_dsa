package recursion;

public class sorted_or_not{

    public static boolean isSorted(int arr[], int i){
        //first base case  
        if( arr.length -1 == i){
            return true ;
        }
        if(arr[i]>= arr[i+1]){
            return false ;
        }
        return isSorted(arr, i+1);
    } 
    public static void main(String[] args) {
        int arrr[]= { 1,2,3,4};
        System.out.println(isSorted(arrr, 0));
    }
}