package testJava;

import java.util.*;

public class IntersectionOfTwoArray {
	
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        
	        // Read size and elements of first array
	        int n1 = sc.nextInt();
	        int[] A = new int[n1];
	        for(int i = 0; i < n1; i++) {
	            A[i] = sc.nextInt();
	        }
	        
	        // Read size and elements of second array
	        int n2 = sc.nextInt();
	        int[] B = new int[n2];
	        for(int i = 0; i < n2; i++) {
	            B[i] = sc.nextInt();
	        }
	        
	        // Find and print intersection
	        findIntersection(A, B);
	        
	        sc.close();
	    }
	    
	    public static void findIntersection(int[] A, int[] B) {
	        // Count frequency of elements in B
	        Map<Integer, Integer> countB = new HashMap<>();
	        for(int num : B) {
	            countB.put(num, countB.getOrDefault(num, 0) + 1);
	        }
	        
	        // Traverse A and print common elements with correct frequency
	        for(int num : A) {
	            if(countB.containsKey(num) && countB.get(num) > 0) {
	                System.out.print(num + " ");
	                countB.put(num, countB.get(num) - 1);  // Decrease count
	            }
	        }
	        System.out.println();
	    }

	}



