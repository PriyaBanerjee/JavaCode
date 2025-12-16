package DSA_Programming;

import java.util.Arrays;

// Scaler classes code practice
public class PracticeCode {
    public static void main(String[] args){
        int[] arr = {4,3,2,7,6,-2};
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
        int specialIndexOutput = specialIndex(arr);
        System.out.println("Special Index count: "+specialIndexOutput);
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

    // Special Index ( very important asked in multiple interview)
    // Special index are those indexes after removing of which total sum of odd indexes and total sum of even indexes is equal
    public static int specialIndex(int[] a){
        // called getprefixEvenIndexes,getprefixOddIndexes
        int n = a.length;
        if (n <= 1) return 0;
        int[] prefix_even =  getprefixEvenIndexes(a);
        int[] prefix_odd = getprefixOddIndexes(a);
        int ans = 0;
        for(int i =0 ; i < n ;i++){
            int sum_even = 0, sum_odd = 0;
            if (i == 0) {
                // Left: empty (0,0)
                // Right: indices 1 to n-1, all parity flipped
                int right_orig_even = prefix_even[n-1] - prefix_even[0];
                int right_orig_odd = prefix_odd[n-1] - prefix_odd[0];
                sum_even = right_orig_odd;  // flipped
                sum_odd = right_orig_even;  // flipped
            }else {
                sum_even = prefix_even[i - 1] + prefix_odd[n - 1] - prefix_odd[i];
                sum_odd = prefix_odd[i - 1] + prefix_even[n - 1] - prefix_even[i];
            }
           if(sum_even == sum_odd){
               ans++;
           }
        }
        return ans;
    }


    //find min and max with minmum length subarray


}
