package Advance_DSA_Classes;

public class Sumatrix_missingnatural_12_01 {
    public static void main(String[] args){
        int[] arr ={1, 2, 0};
        System.out.println("Q1. First Missing Integer: "+firstMissingPositive(arr));
        int[] minSwap = {1, 12, 10, 3, 14, 10, 5};
        System.out.println("Q1. Minimum Swaps: "+minSwapcount(minSwap,8));
        int[][] arr1 = {{0,0, 1, 1}, {0,1, 1, 1},{ 1 ,0, 1, 1},{1,1,1,1}};
        int[][] arr2 = {{0,0, 1, 1}, {0,1, 1, 1},{ 0,1, 1, 1},{1,1,1,1}};
        System.out.println("Q2. Row with maximum number of ones: "+maxnumofonesbfapproach(arr1) );
        System.out.println("Q2. Row with maximum number of ones: "+maxnumofones(arr2) );

    }
    //Q1. First Missing Integer
    //TC: O(N) , SC(1)
    public static int firstMissingPositive(int[] A) {
        int n = A.length;
        for(int i = 0 ; i < n ;i++){
            if(A[i] <= 0){
                A[i] = n+2;
            }
        }

        for(int i = 0; i < n; i++){
            int ele = Math.abs(A[i]);
            if(ele >= 1 && ele <= n){
                int correct_index = ele - 1;
                if(A[correct_index] > 0){
                    A[correct_index] = -1 * A[correct_index];
                }
            }
        }
        for(int i = 0 ; i< n;i++){
            if(A[i] > 0){
                return i+1;
            }
        }
        return n+1;
    }

    //Q2. Sum of all Submatrices
    public int sumofallsubmatrices(int[][] A) {
        return 0;
    }

    //Q1. Minimum Swaps
    //A = [1, 12, 10, 3, 14, 10, 5]
    // B = 8 o/p - 2
    public static int minSwapcount(int[] a, int b){
        int n = a.length;
        if(n <= 0) return 0;
        int goodCount = 0;
        for(int i : a){
            if(i <= b) goodCount++;
        }

        if(goodCount == 0 || goodCount == n) return 0;
        int goodInwindow =0;
        for(int i = 0 ; i < goodCount;i++){
            if(a[i] <= b) goodInwindow++;
        }

        int minSwap = goodCount - goodInwindow;
        for(int i = 1; i <= n-goodCount ; i++){
            if(a[i+goodCount - 1] <= b) goodInwindow++;
            if(a[i-1] <= b) goodInwindow--;
            minSwap = Math.min(minSwap,goodCount-goodInwindow);
        }
        return minSwap;
    }

    //Q2. Row with maximum number of ones - sorted matrix - staircase approach work for sorted matrix
    // A = [   [0, 1, 1]
    //         [0, 0, 1]
    //         [0, 1, 1]   ]  Output 1:0

    //BruteForce  - O(N*M) - this approach work for non - sorted matrix
    public static int maxnumofonesbfapproach(int[][] a){
        int n = a.length;
        int m = a[0].length;
        int maxcount = -1 , bestrow = 0;
        for(int i = 0 ; i < n;i++){
            int cnt = 0;
            for(int j = 0; j < m ;j++){
                if(a[i][j] == 1){
                    cnt++;
                }
            }
            if(cnt > maxcount){
                maxcount = cnt;
                bestrow = i;
            }
        }
        return bestrow;
    }

    public static int maxnumofones(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int maxCount = -1;
        int bestRow = 0;
        int j = m - 1;  // Start from rightmost column
        for (int i = 0; i < n; i++) {
            while (j >= 0 && A[i][j] == 1) {
                j--;
            }
            int ones = m - (j + 1);
            if (ones > maxCount) {
                maxCount = ones;
                bestRow = i;
            }
        }
        return bestRow;
    }

}
