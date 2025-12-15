package DSA_Programming;

import java.util.Arrays;

// Scaler classes code practice
public class PracticeCode {
    public static void main(String[] args){
        int[] arr = {8, 7, 2, 5, 3, 1};
        int[] arr1= { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 };
        int[][] arr2 = {{3, 4}, {-7, 3}, {1, 3}};
        int l = 2;
        //int r = 10;
        int r = 6;
        sumofarrayLtoR(arr1,l,r);
        sumofarray(arr1, arr2);
        prefixSumArray(arr1,l,r);
        int[] prefixOutputEven = getprefixEvenIndexes(arr);
        System.out.println("Even Indexes: " + Arrays.toString(prefixOutputEven));
        int[] prefixOutputOdd = getprefixOddIndexes(arr);
        System.out.println("Odd Indexes: " + Arrays.toString(prefixOutputOdd));
        int[] dummy = new int[7];
        int[] ApOutput =    arithemeticProgression(dummy,1,2);
        System.out.println("Arithmetic Progression : "+ Arrays.toString(ApOutput));
    }


    //given an array N , find sum of elements mentioned from left to right
    //TC : o(1)/o(r-l+1)
    public static void sumofarrayLtoR(int[] a, int l , int r){
        int n = a.length;
        int sum = 0;
        if(r >= n || l < 0 || l>r) {
            System.out.println("Array not under boundary range");
            return;
        }
        for(int i = l ; i<=r;i++){
            //sum = r - l + 1;
            sum += a[i];
        }
        System.out.println("Sum of array from L to r element: "+ sum);
    }

    //if no L and r give then
    public static void sumofarray(int[] a, int[][] queries) {
        int n = a.length;
        for(int[] q : queries){
            int l = q[0];
            int r = q[1];
            if (l < 0 || r >= n || l > r) {
                System.out.println("Invalid: [" + l + "," + r + "]");
                continue;
            }
            int sum =0;
            System.out.println("Valid: [" + l + "," + r + "]");
            for (int k = l; k<= r;k++){
                sum = sum + a[k];

            }
            System.out.println("Sum of valid arrays for 2D: " + sum);
        }
    }

    // prefix Sum code called three function build prefix - where we create an array with prefix sum
    // second get range from the builder prefix array we are picking range and add it
    // third prefix sum array where we calculate all the sum from prefix array
    public static int[] buildprefixarr(int[] a){
     int n = a.length;
     int[] prefix = new int[n];
     prefix[0] = a[0];
     for (int i =1; i< n;i++){
       prefix[i] = prefix[i-1] + a[i];
     }
     return prefix;
    }
    public static int getRangeSum(int[] prefix, int l, int r) {
        if (l == 0) {
            return prefix[r];
        }

        return prefix[r] - prefix[l - 1];
    }

    public static void prefixSumArray(int[] a, int l, int r){
        int n = a.length;
        if(l < 0 || r >= n || l == r){
            System.out.println("Array error or range error");
        }
        int[] prefix = buildprefixarr(a);
        int sum = getRangeSum(prefix,l,r);
        System.out.println("Sum[" + l + ".." + r + "] = " + sum);
    }

    // PREFIX SUM OF Even and odd  indexes
    public static int[] getprefixEvenIndexes(int[] a){
        int n = a.length;
        int[] prefix = new int[n];
        prefix[0] = a[0];
        for ( int i = 1 ; i< n ; i++){
            if (i % 2 == 0){
                // prefix of even indexes
                prefix[i] = prefix[i-1] + a[i];
            }else{
                prefix[i] = prefix[i-1];
            }

        }
        return prefix;
    }

    public static int[] getprefixOddIndexes(int[] a){
        int n = a.length;
        int[] prefix = new int[n];
        prefix[0] = 0;
        for ( int i = 1 ; i< n ; i++){
            if (i % 2 != 0){
                // prefix of odd indexes
                prefix[i] = prefix[i-1] + a[i];
            }else{
                prefix[i] = prefix[i-1];
            }

        }
        return prefix;
    }

    // series Arthiemetic progression a= 1, d =4 find the 6 th term or all terms till 6 th
    //TC : o(n) and SC : O(1)
    public static int[] arithemeticProgression(int[] n, int a, int d){
        //int ap = 0;
        int size = n.length;
        int[] ap = new int[size];
        for(int i = 0; i < size ;i++){
                // d = common difference
                // n = nth element
                // a = first element
                ap[i] = a + (i* d);
        }
        return ap;

    }

}
