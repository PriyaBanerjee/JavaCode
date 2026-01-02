package Self_Practice_Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array_Technique {
    public static void main(String[] args){
        //definition and Initialization
        int[] A = {3,7,3,6,2,8,1,3,2,1,0,9};
        //Method call
        SumOfAllArray(A);
        countEvenOdd(A);
        hammingWeight(32455);
        hammingWeightBK(32455);
        evenNumberRange(A,2,7);
        int[] prefix = buildPrefix(A);
        int countEventop = countEvent(prefix,2,7);
        System.out.println("Total count of even number using Prefix technique: "+countEventop);
        String[] strs = {"flower","flow","flight"};
        String longestCommonPrefixop = String.valueOf(LongestCommonPrefixapp(strs));
        System.out.println("Longest common prefix: " + longestCommonPrefixop);

        int[] removeduplicateop = removeduplicate(A);
        System.out.println("Remove Duplicates from Sorted Array: "+ Arrays.toString(removeduplicateop));
        int[] removeElementvalop = removeElementval(A,3);
        System.out.println("Remove Duplicates from Sorted Array: "+ Arrays.toString(removeElementvalop));
        int[] nums = {4,1,2,1,2};
        int findsingleNumberop = findsingleNumber(nums);
        System.out.println("Find single element where every number in pair : "+ findsingleNumberop);
        int[] nums1 = {-1,0,1,2,-1,-4};
        List<List<Integer>> threesumop= threeSum(nums1);
        System.out.println("Three sum : "+ threesumop);
    }

    // Method definition
    //TC: O(N), SC:O(N) - Sum of All Subarrays (Interview)
    //Prefix sum technique
    public static void SumOfAllArray(int[] A) {
        //prefixSum technique
        int n = A.length;
        if( n ==0 ){
            System.out.println("Empty array");
            return;
        }
        long[] prefixSum = new long[n];
        prefixSum[0] = A[0]; // cleaner base
        for (int i = 1; i < n; i++) {
//            if (i == 0) {
//                prefixSum[i] = A[0];
//            } else {
                prefixSum[i] = prefixSum[i - 1] + A[i];
            //}

        }
        long sum = prefixSum[n - 1];
        System.out.println("Prefix sum array :" + Arrays.toString(prefixSum));
        System.out.println("Total count of Array:"+sum);
    }

    //Count Even/Odd in Range
    // TC : O(N) , SC: O(1)
    public static void countEvenOdd(int[] A){
        int n = A.length;
        if( n ==0 ){
            System.out.println("Empty array");
            return;
        }
        long countEven =0, countOdd = 0;
        for(int i=0;i<n;i++){
             // if (A[i] % 2 == 0) { - normal technique
            // Contribution technique: check LSB using bitwise AND
            if ((A[i] & 1) == 0){
                countEven++;
            } else {
                countOdd++;
            }
        }
        System.out.println("Count Even:" + countEven);
        System.out.println("Count Odd:" + countOdd);
    }

    //Number of 1 Bits -Write a function that takes an unsigned integer and returns the number of '1' bits it has.
    //“Number of 1 Bits” means: given an integer, count how many bits in its binary representation are equal to 1 (this is also called the Hamming weight). For example,
    //n = 13 - n=13 is 1101 in binary and has 3 bits set to 1.
    public static void hammingWeight(int n){
        //TC:O(logN) , SC : O(1)
        int count = 0;
        int x = n;
        while(x>0){
            if((x & 1) != 0){
                count++;
            }
            x = x >> 1;
        }
        int bitlength = (n == 0) ? 1: (32 - Integer.numberOfLeadingZeros(n));
        int zerobites = bitlength - count;
        System.out.println("Normal technique 0: " +zerobites);
        System.out.println("Normal technique 1: " +count);
    }
    //For “Number of 1 Bits” the usuaL O(k) method is exactly Brian Kernighan’s algorithm, where k is the number of set bits (1s). That is already
    //O(k) instead of O(word size):

    public static void hammingWeightBK(int n){
        int count = 0 ;
        int x = n;
        while(x > 0){
            x &= x-1;
            count++;
        }
        int bitlength = (n == 0) ? 1 : (32 - Integer.numberOfLeadingZeros(n));
        int zerobits = bitlength - count;
        System.out.println("Brian Kernighan’s algorithm count 0: " + zerobits);
        System.out.println("Brian Kernighan’s algorithm count 1: " + count);
    }

    //Even numbers in range
    //TC :(n) , sc: O(1)
    public static void evenNumberRange(int[] A, int s, int e){
        int count = 0;
        if ( s < 0 || A.length == 0 || e > A.length || s>e || e == -1){
            System.out.println("Invalid array");
        }
        for(int i = s ; i <= e ; i++){
            if((A[i] & 1) == 0){
                System.out.println("Even numbers : "+A[i]);
                count++;
            }
        }
        System.out.println("Total count of even numbers :"+count);
    }

    public static int[] buildPrefix(int[] A){
        int n = A.length;
        int[] prefix = new int[n];
        prefix[0] = ((A[0] & 1)== 0 ? 1:0);
        for(int i = 1; i<n;i++){
            prefix[i] = prefix[i-1] + (((A[i] & 1) == 0) ? 1: 0);
        }
        return prefix;
    }

    public static int countEvent(int[] prefix , int s, int e){
        if (s < 0) s = 0;
        if (e >= prefix.length) e = prefix.length - 1;
        if (s > e) return 0;
        return prefix[e] - (s > 0 ? prefix[s - 1] : 0);
    }

    //14. Longest Common Prefix - tc (nlogn)
    public static String longestCommonPrefix(String[] str){
        StringBuilder res = new StringBuilder();
        // sort the array
        Arrays.sort(str);
        // find the first and last element
        char[] first = str[0].toCharArray();
        char[] last = str[str.length -1].toCharArray();
        // run a loop on each element
        for (int i =0; i < first.length; i++){
            if(first[i] != last[i])
                break;
            res.append(first[i]);
        }

        return res.toString();
    }
    //14. Longest Common Prefix- prefix sum approach tc: (n)
    public static String LongestCommonPrefixapp(String[] strs){
        if( strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for(int i =0 ; i< strs.length;i++){
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, strs.length -1);
                if(prefix.isEmpty())
                    return null;
            }

        }
        return prefix;
    }

    //26. Remove Duplicates from Sorted Array
    public static int[] removeduplicate(int[] num){
        int n = num.length;
        Arrays.sort(num);
        if(n == 0) return null;
        int j = 1;
        for(int i = 1 ; i < n ; i++){
            if(num[i] != num[i-1]){
                num[j++] = num[i];
            }
        }
        int[] res = new int[j];
        System.arraycopy(num,0,res,0,j);
        return res ;
    }

    //Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
    //7. Remove Element
    public static int[] removeElementval(int[] A, int B){
        int n = A.length;
        int j = 0;
        if(n == 0) return null;
        for(int i =0;i<n;i++){
            if(A[i] != B){
                A[j++] = A[i];
            }
        }
        int[] res = new int[j];
        System.arraycopy(A,0,res,0,j);
        return res;
    }

    public static int findsingleNumber(int[] A) {
        int n = A.length;
        int j = 0;
        for (int i : A) {
           j ^= i;
        }
    return j;
    }

    //Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
    //You must write an algorithm with O(log n) runtime complexity.
    //35. Search Insert Position
    public int searchInsert(int[] nums, int target) {
        return 0;
    }

    //15. 3Sum - Dynamic array
    //Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
    public static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0 ; i < n -2 ;i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i+1;
            int right = n-1;
            while(left < right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicates on right
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right --;
                }else if (sum < 0) {
                    left++;    // need bigger sum
                } else {
                    right--;   // need smaller sum
                }
            }

        }
        return res;
    }
}
