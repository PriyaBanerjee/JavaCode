package DSA_Programming;

import java.util.Arrays;
import java.util.HashSet;

public class Main {
//Main method
    public static void main(String[] args){
        int[] arr = {8, 7, 2, 5, 3, 1};
        int[] arr1= { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 };
        int B = 10;
        findPair(arr,B);
        findAllPair(arr,B);
        int subarray = Subarray(arr1);
        System.out.println("\n" + "Subarry exist : " + subarray);
    }

    //Find all pair with the given sum in an array
    public static void findAllPair(int[] arr , int B){
        // tc : O(n2) and SC : O(1)
        int n = arr.length;
        for(int i =0 ; i< n ; i++){
            for(int j =i+1; j< n ; j++){
                if(arr[i] + arr[j] == B){
                    System.out.printf("("+arr[i] +","+arr[j]+")");
                }
            }
        }
    }

    //Find a pair with the given sum in an array
    public static void findPair(int[] arr , int B) {
        // Sorting appproach
        // tc : n(log n) sc: o(1)
        int n = arr.length;
        Arrays.sort(arr);
        int low = arr[0];
        int high = arr.length - 1;
        while (low < high) {
            // sum found
            if (arr[low] + arr[high] == B) {
                System.out.println("(" + arr[low] + ", " + arr[high] + ")");
                return;
            }
            // increment `low` index if the total is less than the desired sum;
            // decrement `high` index if the total is more than the desired sum
            if (arr[low] + arr[high] < B) {
                low++;
            } else {
                high--;
            }
        }
    }

    //Check if a subarray with 0 sum exists or not
    //Brute force approach
    // time complexity : O(N2)
    public static int Subarray(int[] arr1){
        int n = arr1.length;
        for ( int i =0; i<n ; i++){
            int sum =0;
            for(int j =1; j< n ;j++){
                sum += arr1[j];
                if(sum == 0){
                    return 1;
                }
            }
        }
        return 0;
    }

}


