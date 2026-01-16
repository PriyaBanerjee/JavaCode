package Advance_DSA_Classes;

import java.util.Arrays;

public class watertrap_spiralmat_nextper_1401 {
    public static void main(String[] args){
        int[] arr= {5,4,1,4,3,2,7};
        int[] arr1= {1,2,3,6,5,4};
        int[] arr3 = {9};
        System.out.println("Q1. Rain Water Trapped: "+waterTrapped(arr));
        System.out.println("Q2. Spiral Order Matrix II: "+ Arrays.deepToString(sprialMatrix(4)));
        System.out.println("Q3. Next Permutation: "+ Arrays.toString(nextPermutation(arr1)));
        System.out.println("Q1. Add One To Number/66. Plus One : "+ Arrays.toString(onetonumber(arr3)));
    }
    //Q1. Rain Water Trapped
    //Bruteforce approach
    public static int watertrappedbf(int[] a){
        int n = a.length;
        int totalmax=0;
        int water = 0;
        for(int i = 0;i<n;i++){
            int Lmax=0;
            for(int j = 0; j < i;j++){
                Lmax = Math.max(Lmax,a[j]);
            }
            int Rmax = 0;
            for(int j = i+1;j<n;j++){
                Rmax = Math.max(Rmax,a[j]);
            }
                totalmax = Math.min(Lmax, Rmax) - a[i];
            if(totalmax > 0){
                water = water+totalmax;
            }
        }
        return water;
    }

    //optimized approach - CarryForward approach
    public static int waterTrapped(int[] a){
        int n = a.length;
        int totalwater = 0;
        int water = 0;
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        rmax[n-1] = a[n-1];
        for(int i = n-2; i >=0;i--){
            rmax[i] = Math.max(rmax[i+1],a[i]);
        }
        lmax[0] = a[0];
        for(int i = 1; i < n;i++){
            lmax[i] = Math.max(lmax[i-1],a[i]);
            water = Math.min(lmax[i],rmax[i]) - a[i];
            if(water > 0){
                totalwater = totalwater+water;
            }
        }
        return totalwater;
    }

    //Q2. Spiral Order Matrix II-
    //Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order and return the generated square matrix.
    public static int[][] sprialMatrix(int n){
        int[][] mat = new int[n][n];
        int top = 0, bottom = n-1, left = 0, right = n-1;
        int num = 1;
        while(top <= bottom && left <= right){
            //col left to right
            for(int col = left ; col <= right; col++){
                mat[top][col] = num++;
            }
            top++;
            // row top to bottom
            for(int row = top; row <= bottom;row++){
                mat[row][right] = num++;
            }
            right--;
            if(left <= right){
                for(int col = right ; col >=left;col--){
                    mat[bottom][col] = num++;
                }
                bottom--;
            }
            if(top<= bottom){
                for(int row = bottom;row>=top;row--){
                    mat[row][left] = num++;
                }
                left++;
            }

        }
        return mat;
    }

    //Q3. Next Permutation

    public static int[] nextPermutation(int[] A) {
        int n = A.length;
        if (n < 2) return A;

        // Step 1: Find the rightmost pivot (i where A[i] < A[i+1])
        int i = n - 2;
        while (i >= 0 && A[i] >= A[i + 1]) {
            i--;
        }

        if (i >= 0) {
            // Step 2: Find rightmost successor (j > i where A[j] > A[i])
            int j = n - 1;
            while (A[j] <= A[i]) {
                j--;
            }
            // Step 3: Swap pivot with successor
            swap(A, i, j);
        }
        // Step 4: Reverse suffix after pivot (or entire array if no pivot)
        reverse(A, i + 1, n - 1);
        return A;
    }

    private static void swap(int[] A, int x, int y) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }

    private static void reverse(int[] A, int left, int right) {
        while (left < right) {
            swap(A, left++, right--);
        }
    }

    //Q1. Add One To Number
    //66. Plus One
    public static int[] onetonumber(int[] arr) {
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 9) {
                arr[i] = 0;
            } else {
                arr[i] = arr[i] + 1;
                return arr;
            }
        }

        arr = new int[n + 1];
        arr[0] = 1;

        return arr;
    }
}
