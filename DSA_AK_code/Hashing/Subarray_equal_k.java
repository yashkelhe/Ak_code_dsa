package  Hashing;
import java.util.*;

// this also O(n)
public class  Subarray_equal_k{
    public static void main(String [] args){
        int arr[] ={10, 2, -2, -20, 10};
        int k = -10;


        //here we will addd the first value (sum(j)-k, feq ) 
        HashMap<Integer ,Integer >  map=  new HashMap<>();

        // first we will add the (0,1)

        map.put(0,1);
        int sum =0;
        int ans =0;

        for(int j=0; j<arr.length; j++){
            sum +=arr[j];
            if(map.containsKey(sum-k)){
                ans +=map.get(sum-k);
            }
            // if the sum key is present then return the value of it else return  the default value and  +1
            map.put(sum, map.getOrDefault(sum ,  0)+1);   
        }
        System.out.println("The answer is = "+ ans);
    }
}   