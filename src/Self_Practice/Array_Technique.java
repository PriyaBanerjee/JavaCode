package Self_Practice;

import java.util.Arrays;

public class Array_Technique {
    public static void main(String[] args){
        //definition and Initialization
        int[] A = {3,7,3,6,8,3,2,1,0,9};
        //Method call
        SumOfAllArray(A);
        countEvenOdd(A);
        hammingWeight(32455);
        hammingWeightBK(32455);
        evenNumberRange(A,2,7);
        int[] prefix = buildPrefix(A);
        int countEventop = countEvent(prefix,2,7);
        System.out.println("Total count of even number using Prefix technique: "+countEventop);
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
}
