package Advance_DSA_Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KadaneAlgo_09_01 {
    public static void main(String[] args){
        int A= 10;
        int[] mA = {1, 2, 3, 4, -10};
        System.out.println(maxsum(mA));
        int[][] B = {{1, 3, 10}, {6,9,2}, {3,5,3},{2,8,4},{6,7,5}};
        int[] ans = contiguousSum(A,B);
        System.out.println(Arrays.toString(ans));
        ArrayList<List<Integer>> mer = new ArrayList<>(Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(2, 6),
                Arrays.asList(8, 10),
                Arrays.asList(15, 18)
        ));
        System.out.println(mergeoverlapping(mer));
        String s = "010";
        System.out.println(Arrays.toString(flip(s)));
        int[][] ar = {{1,3},{6,9}};
        int[] br = {2,5};
        System.out.println(insert(ar,br));
    }

    //KadanesAlgo

    //Q1. Max Sum Contiguous Subarray
    //pending
    public static int maxsum(int[] a){
        int n = a.length;
        int sum = 0, maxsum = 0;
        for(int i = 0 ; i< n ;i ++){
            sum = sum + a[i];
            maxsum = Math.max(sum , maxsum);
            if ( sum < 0){
                sum = 0;
            }
        }
        return maxsum;
    }

    //Q2. Continuous Sum Query
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

    //Q3. Merge Sorted Overlapping Intervals - 2 - repeat again ( need to try public int[][] mergoverlap(int[][] A);
    public static ArrayList<ArrayList<Integer>> mergeoverlapping(ArrayList<List<Integer>> A) {
        if (A.isEmpty()) return new ArrayList<>();

        // Sort by start time
        A.sort((a, b) -> Integer.compare(a.get(0), b.get(0)));

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int start = A.get(0).get(0);
        int end = A.get(0).get(1);

        for (int i = 1; i < A.size(); i++) {
            int currStart = A.get(i).get(0);
            int currEnd = A.get(i).get(1);

            if (currStart <= end) {
                end = Math.max(end, currEnd);
            } else {
                // ✅ FIX: Create actual ArrayList, not Arrays.asList()
                ArrayList<Integer> interval = new ArrayList<>();
                interval.add(start);
                interval.add(end);
                result.add(interval);

                start = currStart;
                end = currEnd;
            }
        }

        // Add final interval
        ArrayList<Integer> lastInterval = new ArrayList<>();
        lastInterval.add(start);
        lastInterval.add(end);
        result.add(lastInterval);

        return result;
    }

    //Q1. Flip
    // Flip the arr to get maximum 1's , we can flip only once , if you dont want to flip return empty , else return array
    public static int[] flip(String A) {
        int n = A.length();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ;i++){
            arr[i] = (A.charAt(i) == '0') ? 1 : -1;
        }
        int maxSoFar = 0, maxEndingHere = 0;
        int bestL = -1, bestR = -1, tempL = 0;
        for(int i = 0; i < n;i++){
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            if(maxEndingHere > maxSoFar){
                maxSoFar = maxEndingHere;
                bestL = tempL + 1;
                bestR = i+ 1;
            }
            if(maxEndingHere < 0){
                maxEndingHere = 0;
                tempL = i+1;
            }
        }
        return maxSoFar <= 0 ? new int[]{} : new int[]{bestL, bestR};
    }


    //Q2. Merge Intervals - 2
    //Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
    // [ [1, 5], [6, 9] ]
    public static List<List<Integer>> insert(int[][] A, int[] B) {
        List<List<Integer>> ar = new ArrayList<>();
        int curr_s = B[0];
        int curr_e = B[1];
        int i = 0;
        for(; i < A.length; i++){
            if(A[i][1] < curr_s){
                ar.add(Arrays.asList(A[i][0], A[i][1]));
            } else {
                break;  // Found first overlapping
            }
        }
        for(; i < A.length;i++) {
            if (A[i][1] < curr_s) continue;
            if (A[i][0] < curr_e) {
                curr_s = Math.min(curr_s, A[i][0]);
                curr_e = Math.max(curr_e, A[i][1]);
            } else {
                ar.add(Arrays.asList(curr_s, curr_e));
                curr_s = A[i][0];
                curr_e = A[i][1];
            }
        }
            ar.add(Arrays.asList(curr_s, curr_e));

        return ar;
    }

}
