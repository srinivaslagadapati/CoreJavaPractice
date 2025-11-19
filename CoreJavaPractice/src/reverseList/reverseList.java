package reverseList;

public class reverseList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
		head.next.next.next=new ListNode(4);
		head.next.next.next.next=new ListNode(5);
		
		 printList(head);
		 
		 ListNode prev = reverseListNode(head);
		 
		 printList(prev);
		 
		 ListNode head1 = new ListNode(1);
			head1.next=new ListNode(2);
			head1.next.next=new ListNode(3);
			head1.next.next.next=new ListNode(4);
			head1.next.next.next.next=new ListNode(5);
			head1.next.next.next.next.next=new ListNode(6);
		 
		 printList(head1);
		 int n=2,  m=4;
		 ListNode prev1 = reverseBetween(head1, n,  m);
		 
		 printList(prev1);
		 

	}
	private static ListNode reverseListNode(ListNode head) {
		ListNode current = head;
		ListNode prev= null;
		
		while(current != null) {
			ListNode nextNode =  current.next;
			current.next = prev;
			prev = current;
			current = nextNode;
		}
		return prev;
		
	}
	public static ListNode reverseBetween(ListNode head, int left, int right) {
		System.out.println("--");
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		System.out.println("dummy 1");
		printList(dummy);
		ListNode nodeBeforeLeft = dummy;
		for (int i=0;i<left-1;i++) {
			nodeBeforeLeft = nodeBeforeLeft.next;
		}
		System.out.println("dummy 2");
		printList(dummy);
		System.out.println("nodeBeforeLeft full ");
		printList(nodeBeforeLeft);
		
		ListNode sublistTail = nodeBeforeLeft.next;
		System.out.println("sublistTail");
		printList(sublistTail);
	
		ListNode curr = sublistTail;
		System.out.println("curr bft");
		printList(curr);
		ListNode prev = null;
		for (int i=0;i<right-left+1;i++) {
			//if( i >left && i<right) {
				ListNode next = curr.next;
				curr.next = prev;
				prev= curr;
				curr = next;
		}
		System.out.println("dummy 3");
		printList(dummy);
		System.out.println("nodeBeforeLeft after loop");
		printList(nodeBeforeLeft);
		System.out.println("sublistTail");
		
		printList(sublistTail);
		System.out.println("curr aftr loop");
		printList(curr);
		System.out.println("prev");
		printList(prev);
		sublistTail.next = curr;
		nodeBeforeLeft.next = prev;
		
	
		System.out.println("dummy");
		printList(dummy);
		return dummy.next;
        
    }
	static void printList(ListNode head) {
		ListNode curr = head;
		StringBuilder sb = new StringBuilder();
		
		while (curr != null) {
			sb.append(curr.val);
			if (curr.next != null)
				sb.append("->");
		//	System.out.println(curr.val);
			curr= curr.next;
		}
		System.out.println("  "+sb.toString());
	}

}



class ListNode{
	ListNode next;
	ListNode head;
	int val;
	
	
	ListNode(int val, ListNode next){
		this.val=val;
		this.next=next;
	}
	ListNode(int val){
		this.val=val;
	}
	ListNode(ListNode next){
		this.next=next;
	}
}
