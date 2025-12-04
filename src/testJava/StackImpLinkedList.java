package testJava;

import java.util.LinkedList;

public class StackImpLinkedList {
	
	public static void main(String[] args) {
		LinkedList<Integer> st = new LinkedList<>();
		
		st.addLast(10);
		st.addLast(20);
		st.addLast(30);
		st.addLast(40);
		st.addLast(50);
		
		System.out.println(st.removeFirst());
		System.out.println(st.removeLast());
		
	}

}
