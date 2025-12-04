package testJava;

public class ArrayClass {
	
	public int[] searcharray(int[] A, int[][] B) {
		// TODO Auto-generated method stub
		int n = A.length;
        int[] result = new int[n];
        result[0] = (A[0] % 2 == 0) ? 1 : 0;
        for(int i = 1; i < n; i++){
            result[i] = result[i - 1] + ((A[i] % 2 == 0) ? 1 : 0);
        }
        int m = B.length;
        int[] answers = new int[m]; 
        for(int i = 0; i < m; i++){
            int L = B[i][0];
            int R = B[i][1];
            if(L == 0){
                answers[i] = result[R];
            } else {
                answers[i] = result[R] - result[L - 1];
            }
        }
        return answers;
	}
	
	public int sumarray(int[] A) {
		int n = A.length;
		int sum = 0;
		for(int i =0 ; i< n; i++) {
			sum = sum + A[i];
		}
		return sum;
	}

	public int maxarray(int[] A) {
		int max = A[0];
		for (int i =0 ; i< A.length; i++) {
			if(A[i]>max) {
				max = A[i];
			}
		}
		return max;
	}
	
	public int reversearray(int[] arr) {
		int i =0 ;
		int j = arr.length -1;
		int temp=0;
		while(i<j) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		return temp;
		
	}
	
	
	//NEED TO FIX
	public int subarrays(int[] arr) {
		int si =0 ;
		int ei=0;
		int n = arr.length;
		int temp =0;
		for(si=0;si<n;si++) {
			for(ei=si;ei<n;ei++) {
				for (int k=0;k<= ei;k++) {
					temp=arr[k];
				}
				
			}
		}
		return temp;
	}
}
