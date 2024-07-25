package bit_wise_operators;

// clear the ith bit 
// i = 1
// n = 10 

// 1010 -> ( 10)
// 1101

// 1000 -> ( 8)
// Bit positions:  3  2  1  0
public class clear_ith_bit {
    public static int clearIthBit(int n, int i) {
        int bitmask = ~(1 << i);
        return n & bitmask;
    }

    public static void main(String[] args) {   
        System.out.println(clearIthBit(2, 3));
    }
}



class Solution {

    public int[] twoSum(int[] nums, int target) {

        for(int i = 0 ; i < nums.length-1  ; i ++ ){
            for(int j = i+ 1 ; j< nums.length  ;  j++){
                if ((nums[i] + nums [j]) == target ){    
                    return new int[] {i , j} ;
                }
            }  
        }
    }
} 


abstract class animal {
    void eat(){
        System.out.println("print");
    }
    abstract  void cat();
}