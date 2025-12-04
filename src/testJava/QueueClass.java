package testJava;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueClass {

	public static void main(String[] args) {
		Queue<Integer> queue = new ArrayDeque<>();
		
		queue.offer(10);
		queue.offer(20);
		queue.offer(30);
		queue.offer(40);
		
		// get the front elemet 
		System.out.println(queue.peek());
		
		//remove
		System.out.println(queue.remove());
		
		System.out.println(queue.peek());
		
		//size
		System.out.println(queue.size());
	}
	
}
