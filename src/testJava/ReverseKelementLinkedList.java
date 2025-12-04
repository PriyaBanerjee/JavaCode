package testJava;

import java.util.*;

public class ReverseKelementLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Queue<Integer> lt = new LinkedList<>();
			
			lt.offer(10);
			lt.offer(20);
			lt.offer(30);
			lt.offer(40);
			lt.offer(50);
			
			
			reverse(lt,2);
			

	}
	
	
	public static void reverse(Queue<Integer> queue, int k) {
		if (queue.isEmpty() || k > queue.size() || k <= 0) {
	        return;
	    }
		Stack<Integer> st = new Stack<>();
		
		for(int i =0; i < k;i++) {
			st.push(queue.remove());
		}
		
		while(!st.isEmpty()) {
			queue.offer(st.pop());
		}
		
		int count = queue.size() - k;
		
		for(int i =0 ; i< count; i++) {
			queue.offer(queue.remove());
		}
		System.out.println("show current list : " + queue);
	}
	 

}
