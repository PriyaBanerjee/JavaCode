package Advance_DSA_Classes;

import java.util.Arrays;

public class KadaneAlgo_09_01 {
    public static void main(String[] args){
        int A= 10;
        int[][] B = {{1, 3, 10}, {6,9,2}, {3,5,3},{2,8,4},{6,7,5}};
        int[] ans = contiguousSum(A,B);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] contiguousSum(int A, int[][] B){
        int[] arr = new int[A];
        for(int q = 0 ; q < B.length; q++){
            int i = B[q][0];
            int j = B[q][1];
            int k = B[q][2];
            arr[i-1] = arr[i-1] + k;
            if(j < A){
                arr[j] = arr[j] - k;
            }
        }
        for(int ind = 1 ; ind < A ; ind++){
            arr[ind] = arr[ind - 1] + arr[ind];
        }
        return arr;
    }
}
