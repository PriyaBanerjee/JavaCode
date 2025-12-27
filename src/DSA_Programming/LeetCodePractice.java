package DSA_Programming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCodePractice {
    public static void main(String[] args){
        int x = 121;
        int[] nums = {-1,1,-2,2,-3,3,4,5,6};
        int target = 9;
        int[] ans = twoSum(nums,target);
        System.out.println(Arrays.toString(ans));
        isPalindrome(x);
        random(nums);
       int maxop = maxSubarray(nums);
       System.out.println(maxop);
       int[] a = {7,1,5,3,6,4,8,5,6,4,3};
        int maximumProductSubarrayop = maximumProductSubarray(a);
        System.out.println("Maximum Product Subarray: "+ maximumProductSubarrayop);
        int findMinop = findminBinarySearch(a);
        System.out.println("Find Minimum in Rotated Sorted Array: "+findMinop);
        int maxprofitop = maxprofit(a);
        System.out.println("Best Time to Buy and Sell Stock: "+maxprofitop);
        boolean containsDuplicateop = containsDuplicate(a);
        System.out.println("Contain Duplicate: "+ containsDuplicateop);
        int[] a1 = {4,5,6,7,1,2};
        int search_Binaryop = search_Binary(a1,7);
        System.out.println("Search in Rotated Sorted Array: "+search_Binaryop);
        int[] productExceptSelfop = productExceptSelf(a1);
        System.out.println("Product of Array Except Self: "+ Arrays.toString(productExceptSelfop));
        int[] n = {1,8,6,2,5,4,8,3,7};
        int maxAreaop = maxArea(n);
        System.out.println("Container With Most Water: "+maxAreaop);
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

    public static void random(int[] a){
        int n = a.length;
        Arrays.sort(a);
        if ( n == 0 && n < 2){
            System.out.println("Invalid array");
        }
        int right = a[n-2] * a[n-1];
        int left= a[0] * a[1];
        if (right-left>0){
            System.out.println(right);
            System.out.println(Arrays.toString(Arrays.copyOfRange(a, n - 2,n)));
        }else if(right - left < 0){
            System.out.println(left);
            System.out.println(Arrays.toString(Arrays.copyOfRange(a, 0,2)));

        }else{
            System.out.println(right);
        }
    }

    //53. Maximum Subarray
    public static int maxSubarray(int[] a){
        int n = a.length;
        //int[] prefix = new int[n];
        int prefix = a[0];
        int max = a[0];
        for(int i =1; i<n;i++){
                prefix = Math.max(a[i] + prefix, a[i]);
                max = Math.max(prefix, max);
        }
        return max;
    }

    //152. Maximum Product Subarray
    public static int maximumProductSubarray_w(int[] a){ // not working for -ve scenario
        int n = a.length;
        int[] prefix_Left = new int[n];
        int[] prefix_right = new int[n];
        prefix_Left[0] = a[0];
            for(int left = 1 ;left<n;left++){
                prefix_Left[left] = prefix_Left[left-1] * a[left];
                //System.out.println("left: "+ Arrays.toString(prefix_Left));
            }
            prefix_right[n-1] = a[n-1];
            for(int right = n-2 ; right>= 0; right-- ){
                prefix_right[right] = prefix_right[right + 1] * a[right];
                //System.out.println("right: "+ Arrays.toString(prefix_right));
            }
        int max_so_far = 0;
        int max = 0;
        for(int i =0;i<n;i++){
            max = Math.max(prefix_right[i],prefix_Left[i]);
            max_so_far = Math.max(max_so_far,max);
        }


        return max_so_far;
    }

    public static int maximumProductSubarray(int[] nums){

        int n = nums.length;
        int leftproduct = 1;
        int rightproduct = 1;
        int ans = nums[0];
        for(int i =0 ; i < n ;i++){
            leftproduct = leftproduct == 0 ? 1 : leftproduct;
            rightproduct = rightproduct == 0 ? 1: rightproduct;

            leftproduct *= nums[i];
            rightproduct *= nums[n - 1 - i];// nums[7-1-0]

            ans = Math.max(ans, Math.max(leftproduct,rightproduct));
        }
        return ans;
    }

    //153. Find Minimum in Rotated Sorted Array
    public static int findMin(int[] nums) { // correct completely // TC :O(N)
        int n = nums.length;
        int min = nums[0];
        for(int i =1 ;i <n;i++){
            min = Math.min(min , nums[i]);
        }
        return min;
    }
    public static int findminBinarySearch(int[] nums){
        int n = nums.length;
        int left = 0;
        int right = n -1;
        while (left < right){
            int mid = left+ (right - left)/2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return nums[left];
    }

    //121. Best Time to Buy and Sell Stock - TC : O(N)
    //You are given an array prices where prices[i] is the price of a given stock on the ith day.
    //You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    //Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
    public static int maxprofit(int[] a){
        int n = a.length;
        int buy_price = a[0];
        int profit = 0 ;
        for(int i =1;i< n ;i++){
            if(a[i] < buy_price){
                buy_price = a[i];
            }else{
                int curr_profit = a[i] - buy_price;
                profit = Math.max(curr_profit,profit);
            }
        }
        return profit;
    }
    //Contains Duplicate
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> has = new HashSet<>();
        int n = nums.length;
        for(int i : nums){
            if(has.contains(i))
                return true;
            has.add(i);
        }
        return false;
    }

    //33. Search in Rotated Sorted Array
    public static int search_Binary(int[] a, int target){
        int n = a.length;
        int left = 0 ;
        int right = n-1;
        while (left <= right){
            int mid = left +((right - left)/2);
            if(a[mid] == target) return mid;
            //check if the left array is sorted
            if (a[left] <= a[mid]){
                if(a[mid] > target && target >= a[left]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                // check if the right array is sorted or not
                if(a[mid] < target && target <= a[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }

        }
    return -1;
    }

    //238. Product of Array Except Self
    public static int[] productExceptSelf(int[] a) {
        int n = a.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n];

        // iterate through left and multiply all element
        left[0] = 1;
        for(int i = 1 ; i < n ; i++){
            left[i] = left[i-1] * a[i-1];
        }

        //iterate through right and miltiply all element
        right[n-1] = 1;
        for(int i = n-2; i >= 0; i--){
            right[i] = right[i+1] * a[i+1];
        }
        // now multiply right and left element
        for(int i = 0 ; i< n ; i++){
            ans[i] = right[i] * left[i];
        }
        return ans;
    }

    //11. Container With Most Water
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left <right){
            int Area = Math.min(height[left],height[right]) * (right - left);
            maxArea = Math.max(maxArea,Area);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }

}
