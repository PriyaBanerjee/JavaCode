package DSA_Programming;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Array_Sorting {
    public static void main(String[] args) {
        //declares and initializes
        int[] A = {2, 1};
        //call without static method
        Array_Sorting obj = new Array_Sorting();
        int elementRemovalOp = obj.elementRemoval(A);
        System.out.println("Total Cost for element Removal: " + elementRemovalOp);

    }

    //Methods and Functions
    //Given an integer array A of size N. You can remove any element from the array in one operation.
    //The cost of this operation is the sum of all elements in the array present before this operation.
    //Find the minimum cost to remove all elements from the array.
    public int elementRemoval(int[] A){
        Integer[] sorted = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Arrays.sort(sorted, Collections.reverseOrder());
        long sum = 0, totalCost = 0;
        for(int i = 0 ; i< sorted.length; i++){
            sum += sorted[i];
            totalCost += sum;
        }
    return (int)totalCost;
    }
}
