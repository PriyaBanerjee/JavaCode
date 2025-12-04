package testJava;


public class LinkedListClass {
	
	public static class Node{
		public int val ;
		Node next;
		Node(int val){
			this.val = val;
		}
	}
	
	public static void main (String[] args) {
		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		Node head = n1;
		
		printList(head); // Original: 10 20 30 40 50
        
        head = addFirst(head, 3);
        printList(head); // After addFirst: 0 10 20 30 40 50
        
        head = addLast(head, 60);
        printList(head); // After addLast: 0 10 20 30 40 50 60
		
        head = addList(head, 15,0);
        printList(head);
        
        head = RemoveFirst(head);
        printList(head);
        
        head = RemoveLast(head);
        printList(head);
        
        head = RemoveAt(head, 30);   // Remove node with value 30
        printList(head);
        
        System.out.println(LengthLinklist(head));
        System.out.println(FindKLinkList(head,80));//false
        System.out.println(FindKLinkList(head,20));//true
	}
	
	public static Node addFirst(Node head, int val) {
		Node n = new Node(val);
		
		n.next = head;
		head = n;
		
		return head;
	}
	
	public static Node addLast( Node head, int val) {
		Node n = new Node(val);
		Node tail = head;
		while(tail.next != null) {
			tail = tail.next;
		}
		
		tail.next = n;
		return head;
	}
	
	
	public static Node addList(Node head, int val, int k) {
		Node n = new Node (val);
		
		// if insert inside the head
		if(head == null) {
			addFirst(head, val);
		}
		Node temp = head;
		
		// traverse until next code 
		for(int i = 1; i < k-1; i++) {
			temp = temp.next;
			
		}
		if(temp == null) {
			System.out.println("Position out of bound");
			return head;
		}
		// mInset new node after temp;
		Node temp1 = temp.next;
		temp.next = n;
		n.next = temp1;
		return head;
	}
	
	
	public static Node RemoveFirst(Node head) {
		if( head == null) {
			return null;
		}
		
		head = head.next;
		return head;
	}
	
	public static Node RemoveLast(Node head) {
		if(head == null) {
			return null;
		}
		if(head.next == null) {
			return null;
		}
		Node tail = head;
		while(tail.next.next != null) {
			tail = tail.next;	
		}
		tail.next = null;
		return head;
		
	}
	
	   public static Node RemoveAt(Node head, int val) {
	        if (head == null) return null;
	        if (head.val == val) return head.next;
	        Node current = head;
	        while (current.next != null && current.next.val != val) {
	            current = current.next;
	        }
	        if (current.next != null) {
	            current.next = current.next.next;
	        }
	        return head;
	    }
	
	public static int LengthLinklist(Node head) { 
	    int count = 0;
	    if (head == null) {
	        return 0;
	    }
	    Node temp = head;
	    
	    while (temp != null) {  // ✅ Traverse until end
	        count++;
	        temp = temp.next;
	    }
	    
	    return count;
	}

	public static boolean FindKLinkList(Node head, int val) {
		Node n = new Node(val);
		if(head == null) {
			return false;
		}
		
		Node temp = head;
		
		while(temp != null) {
			if(temp.val == val) {
				return true;
			}
			temp = temp.next;
		}
		

			return false;
	}
	
	// Helper method to print list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

}
