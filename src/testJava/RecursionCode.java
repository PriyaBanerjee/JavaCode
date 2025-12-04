package testJava;
import java.util.*;

public class RecursionCode {
	
	public static void main(String[] args) {
		PrintIncreasing(10);
		int[] arr= {10,30,40,50,20};
		PrintArray(arr,0);
		
		int n = 10;
		System.out.println(PrintFirstIndex(arr,n,0));
		
		System.out.println(Factorial(n));
	}

	
	public static void PrintIncreasing(int N) {
		if(N==0) {
			return;
		}
		PrintIncreasing(N-1);
		System.out.print(N + " ");
	}
	
	public static void PrintArray(int[] arr,int i ) {
			if(i== arr.length) {
				return;
			}
			
			System.out.print(arr[i] + " ");
			PrintArray(arr,i+1);
			
		}
	
	public static int PrintFirstIndex(int[] arr, int n, int i) {
		if(i == arr.length) {
			return -1;
		}
			if(arr[i] == n) {
				return i;
			}else {
				int idx = PrintFirstIndex(arr, n , i+1);
				return idx;
			}
		}
	
	public static int Factorial(int n) {
		
		if (n ==0) {
			return 1;
		}
		int nm1fact = Factorial(n-1);
		return n * nm1fact;
	}
	
	
}
