package testJava;

public class SortingClass {

	
	public static void main(String[] args) {
		int[] arr = {1,5,2,4,3,6,9,8,10};
		SelectionSort(arr);
		BubbleSort(arr);
		InsertionSort(arr);
		
	}
	
	public static void SelectionSort(int[] arr) {
		for (int i =0 ; i< arr.length - 1; i++) {
			int minval = arr[i];
			int minidx = i;
			for (int j = i+1 ; j<arr.length;j++) {
				if(arr[j]<minval) {
					minval= arr[j];
					minidx = j;
				}
			}
			
			int temp = arr[i];
			arr[i]=arr[minidx];
			arr[minidx] = temp;
			
			
		}
		for(int val : arr) {
			System.out.println(val);
			
		}
	}
	
	public static void BubbleSort(int[] arr) {
		for(int i = 0 ; i < arr.length -1;i++) {
			
			for (int j =0 ; j< arr.length-1 - i; j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j]= arr[j+1];
					arr[j+1]= temp;
				}
			}
			
		}
		for ( int val: arr) {
			System.out.println(val);
		}
	}
	
	public static void InsertionSort(int[] arr) {
		for(int i =1; i<arr.length;i++) {
			int key = arr[i];
			
			int j = i-1;
			while(j>=0 && arr[j]> key) {
				arr[j+1] = arr[j];
				j--;
			}
			
			arr[j+1] = key;
		}
		
		for (int val : arr) {
			System.out.println(val);
		}
	}
	
	
	//Arrays.sorts(arr); 
}
