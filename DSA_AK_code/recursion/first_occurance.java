package recursion;
// find the first occurance in the array
public class first_occurance {
    public static int firstOccurance(int key, int arr[], int i){
        // base case 
        if( arr.length- 1 == i){
            return -1;
        }
        if( arr[i]==  key){
            return i;
        }
        return  firstOccurance(key, arr, i+1);
   }
    public static void main(String[] args) {
        int arr[]= { 9, 3 ,4 , 5 , 8 , 11};
        System.out.println(firstOccurance(5, arr, 0));
    }
}
