package DSA_Programming;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Array_Sorting {
    public static void main(String[] args) {
        //declares and initializes
        int[] A = {3,2,4,6,3,4,6,9,0,4,5,7,8,5,3};
        int[] nobleInteger = {-10,-5,3,4,1,5};
        int B = 6;
        //call without static method
        //19/12/2025- Memory Management and sorting Basic
        Array_Sorting obj = new Array_Sorting();
        int elementRemovalOp = obj.elementRemoval(A);
        System.out.println("Total Cost for element Removal: " + elementRemovalOp);
        int arithmeticProgressionOp = arithmeticProgression(A);
        System.out.println("See if the array can be arrange in form of Arithmetic Progression: " + arithmeticProgressionOp);
        int kthSmallestElementOp = kthSmallestElement(A,B);
        System.out.println("Kth Smallest Element: " + kthSmallestElementOp);
        int nobleIntegerCountOp = nobleIntegerCount(nobleInteger);
        System.out.println("Noble Integer count: " + nobleIntegerCountOp);
    }

    //Methods and Functions
    //Given an integer array A of size N. You can remove any element from the array in one operation.
    //The cost of this operation is the sum of all elements in the array present before this operation.
    //Find the minimum cost to remove all elements from the array.
    public int elementRemoval(int[] A){
        Integer[] sorted = Arrays.stream(A).boxed().toArray(Integer[]::new);
        //Arrays.sort(sorted, Collections.reverseOrder()); - Descending order
        Arrays.sort(sorted); // ascending order
        long sum = 0, totalCost = 0;
        for(int i = 0 ; i< sorted.length; i++){
            sum += sorted[i];
            totalCost += sum;
        }
    return (int)totalCost;
    }

    //Given an integer array A of size N. Return 1 if the array can be arranged to form an arithmetic progression, otherwise return 0.
    //A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
    public static int arithmeticProgression(int[] A){
        Integer[] sorted = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Arrays.sort(sorted);
        long commonDif = sorted[1] - sorted[0];
        for(int i = 2; i < sorted.length; i++){
            if(sorted[i] - sorted[i-1] != commonDif){
                return 0;
            }
        }

        return 1 ;
    }

    //Find the Bth smallest element in given array A .
    //NOTE: Users should try to solve it in less than equal to B swaps.
    public static int kthSmallestElement(int[] A, int B){
        Integer[] sorted = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Arrays.sort(sorted);
        System.out.println("Sorted array:" + Arrays.toString(sorted) );
        return sorted[B-1];
    }

    //Given an integer array A,
    // find if an integer p exists in the array such that the number of integers greater than p in the array equals p.
    //Noble(p) = Number of elements STRICTLY GREATER than p == p - > condition if (sorted[i] == n - i - 1)
    public static int nobleIntegerCount(int[] A){
        Integer[] sorted = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Arrays.sort(sorted);
        System.out.println(Arrays.toString(sorted));
        long count = 0;
        int n= sorted.length;
        for(int i = 0; i < n; i++) {
            // Fix 1: Use sorted[i], not A[i]
            //sorted[i] = n-i-1 - if actual noble element statement need to establish which is A[i] = no. of element greater than A[i]
            if(sorted[i] == i && (i == n-1 || sorted[i] != sorted[i+1])) {
                count++;
                System.out.println("Noble found: " + sorted[i] + " at position " + i);
            }
        }
        return (int)count ;
    }
}
