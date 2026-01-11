package Advance_DSA_Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KadaneAlgo_09_01 {
    public static void main(String[] args){
        int A= 10;
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
    }

    //KadanesAlgo

    //Q1. Max Sum Contiguous Subarray
    //pending

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




}
