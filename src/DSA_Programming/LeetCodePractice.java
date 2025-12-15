package DSA_Programming;

import java.util.Arrays;

public class LeetCodePractice {
    public static void main(String[] args){
        int x = 121;
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] ans = twoSum(nums,target);
        System.out.println(Arrays.toString(ans));
        isPalindrome(x);
    }

    //1. Two Sum
    //Input: nums = [2,7,11,15], target = 9
    //Output: [0,1]
    //Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for(int i = 0 ; i< n -1 ; i++){
            for(int j = i+1; j< n  ; j++){
                if(nums[i]+ nums[j] == target ){
                    return new int[] {i,j};
                }
            }

        }
        return new int[] {-1,-1};

    }

    public static void isPalindrome(int x){
        if(x < 0 ){
            System.out.println("Not palindrome");
        }
        int original = x;
        int reversed = 0;
        while ( x > 0){
            int digit = x% 10;
            reversed = reversed * 10 + digit;
            x /=  10;
        }
        if ( original == reversed ){
            System.out.println("Number is Palidrome: "+ x);
        }
        System.out.println("Not Palindrome");
    }
}
