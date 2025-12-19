package DSA_Programming;

import java.util.Arrays;

// Scaler classes code practice
public class PracticeCode {
    public static void main(String[] args){
        int[] arr = {4,3,2,7,6,-2};
        int[] arr3 = {1,2,8,4,9,3,2};
        int[] arr1= { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 };
        int[][] arr2 = {{3, 4}, {-7, 3}, {1, 3}};
        int[][] arr4 = {{3, 4}, {1, 3}, {2, 5}};
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
        System.out.println("Special Index count: " + specialIndexOutput);
        int MinMaxSubarrayOutput = MinMaxSubarray(arr3);
        System.out.println("Subarry minimum length: " + MinMaxSubarrayOutput);
        int[] A={1,2,3,4,5};
        int[][] B={{0,2},{2,4},{1,4}};
        int[] evenNumberRangeOutput = evenNumberRange(A,B);
        System.out.println("Even number from a range: " + Arrays.toString(evenNumberRangeOutput));
        int sumoddIndexedElementOP  = sumoddIndexedElement(arr);
        System.out.println("Sum of odd indexed element: " + sumoddIndexedElementOP);
        int sumevenIndexedElementOP  = sumevenIndexedElement(arr);
        System.out.println("Sum of even indexed element: " + sumevenIndexedElementOP);
        int[] arr_maxprofit= { 2,4,1,4,7,8,5 }; // output is 7
        int BestTimeToBuyandSellstockOP  = BestTimeToBuyandSellstock(arr_maxprofit);
        System.out.println("Maximum Profit: " + BestTimeToBuyandSellstockOP);
        int[] A1 = {6, 7, 8, 2};
        int B1 = 2;
        int maxSumFixedLengthOP  = maxSumFixedLength(A1,B1);
        System.out.println("Maximum Sum: " + maxSumFixedLengthOP);
        int leastaverageSubarrayOP  = leastaverageSubarray(A1,B1);
        System.out.println("Subarray with least average: " + leastaverageSubarrayOP);
        int[] A2 = {2, 5, 6};
        int B2 = 10;
        int countingSubarrayOP  = countingSubarray(A2,B2);
        System.out.println("Counting Subarrays: " + countingSubarrayOP);
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


    //find min and max with minimum length subarray
    public static int MinMaxSubarray(int[] a){
        int n = a.length;
        int min = a[0];
        int max = a[0];
        for(int i =0 ; i<n;i++){
            min = Math.min(min, a[i]);
            max = Math.max(max,a[i]);
        }
        if (min == max) return 1;
        int last_min = -1;
        int last_max = -1;
        int minlength = n;
        for(int i =n-1 ; i>=0 ; i--){
            if (a[i] == max){
                    last_max = i;
                }
            if(a[i] == min){
                last_min = i;
            }
            if (last_max != -1 && last_min != -1){
                int currlength = Math.abs(last_min - last_max) + 1;
                minlength = Math.min(minlength,currlength);
            }

        }
        return minlength;
    }

    //Even numbers in a range
    public static int[] evenNumberRange(int[] a, int[][] range) {
        int n = a.length;
        int q = range.length;
        int[] prefix_even = new int[n+1];
        for(int i = 0; i < n; i++) {
            if(a[i] % 2 == 0) {
                prefix_even[i+1] = prefix_even[i] + 1;
            } else {
                prefix_even[i+1] = prefix_even[i];
            }
        }
        // otherways to write the above line
        //Original ternary is best!- prefix_even[i+1] = prefix_even[i] + (a[i] % 2 == 0 ? 1 : 0)
        // integer division - for(int i = 0; i < n; i++) {
        //    prefix_even[i+1] = prefix_even[i] + ((a[i] & 1) ^ 1);  // 0 for even, 1 for odd → flip
        //}
        //math.abs -  prefix_even[i+1] = prefix_even[i] + (1 - Math.abs(a[i] % 2));
        int[] result = new int[q];
        for(int i =0 ; i < q;i++){
            int left = range[i][0];
            int right = range[i][1];
            // prefix[] = r - l + 1;
            result[i] = prefix_even[right +1] - prefix_even[left];
        }
        return result;
    }

    //Sum of odd indexed element in a range
    // TC = O(N) , sc : O(n)
    public static int sumoddIndexedElement(int[] a){
        int n = a.length;
        if (n == 0) return 0;
        int[] prefix_Sum = new int[n];
        int result = 0;
        prefix_Sum[0] = 0;
        for(int i = 1 ; i < n;i++){
            if(i%2 != 0){
                prefix_Sum[i]= prefix_Sum[i-1] + a[i];
            }else{
                prefix_Sum[i] = prefix_Sum[i-1];
            }
            result = prefix_Sum[n-1];
        }
        return result;
    }

    // above code optimized way // tc : n and sc : 1
    public static int sumoddIndexedElement_optimized(int[] a) {
        int sum = 0;
        for (int i = 1; i < a.length; i += 2) {
            sum += a[i];
        }
        return sum;
    }

    // tc : n and sc : 1
    public static int sumevenIndexedElement(int[] a){
        int sum = 0;
        int n = a.length;
        for(int i = 0; i < n ; i += 2 ){
            sum += a[i];
        }
        return sum;
    }

    public static int BestTimeToBuyandSellstock(int[] a){
        int max_profit = 0;
        int minprice = a[0];
        int n = a.length;
        if ( n == 0) return 0;
        for(int i = 0; i < n; i++){
            if(a[i] < minprice){
                minprice = a[i];
            }else{
                max_profit = Math.max(max_profit , a[i] - minprice);
            }
        }
        return max_profit;
    }

    // maximum sum of fixed length
    //tc : O(n) SC: 1
    public static int maxSumFixedLength(int[] A, int B){
        int n = A.length;
        long sum = 0;

        for(int i = 0 ; i < B; i++){
            sum += A[i];
            System.out.println("Sum"+sum);

        }
        long max = sum;
        for(int j = B ; j < n; j++){
            sum += A[j];
            sum -= A[j - B];
            if ( sum > max ){
                max = sum;
                System.out.println(sum);
            }
        }

        return Math.toIntExact(max);
    }
    //Given an array A of size N, find the subarray of size B with the least average.
    public static int leastaverageSubarray(int[] A, int B){
        int n = A.length;
        long average = 0;
        long sum = 0;
        for(int i =0 ; i < B; i++){
            sum += A[i];
        }
       long minSum = sum;
        int minstartindex = 0;
        for(int i = B; i < n ; i++){
            sum += A[i];
            sum -= A[i - B];
            if(sum < minSum){
                sum = minSum;
                minstartindex = i - B + 1;
            }
        }
        return minstartindex;
    }

    //Given an array A of N non-negative numbers and a non-negative number B,
    //you need to find the number of subarrays in A with a sum less than B.
    //We may assume that there is no overflow.
    public static int countingSubarray(int[] A, int B) {
        int n = A.length;
        int left = 0;
        long sum = 0;
        int count = 0;
        if ( n < 0) return 0;
        for(int i =0 ; i<n;i++){
            sum += A[i];
            while(left <= i && sum >= B){
                sum -= A[left];
                left ++;
            }
            count += (i - left + 1);
        }
    return count ;
    }

}
