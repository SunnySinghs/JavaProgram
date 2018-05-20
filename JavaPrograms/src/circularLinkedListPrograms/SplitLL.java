package circularLinkedListPrograms;

import doubleLinkListPrograms.Node;

public class SplitLL {
	Node node, head1, head2;
	public static void main(String[] args) {
		SplitLL list = new SplitLL();

		//Created linked list will be 12->56->2->11
		list.node = new Node(12);
		list.node.next = new Node(56);
		list.node.next.next = new Node(2);
		list.node.next.next.next = new Node(11);
		list.node.next.next.next.next = list.node;

		System.out.println("Original Circular Linked list ");
		list.printList(list.node);

		// Split the list
		list.splitLL();
		System.out.println("");
		System.out.println("First Circular List ");
		list.printList(list.head1);
		System.out.println("");
		System.out.println("Second Circular List ");
		list.printList(list.head2);

	}
	
	 void splitLL() {
		 if(node == null) {
			 return;
		 }
		 Node fast = node;
		 Node slow = node;
		 if(fast.next!=node && fast.next.next!=node) {
			 fast = fast.next.next;
			 slow = slow.next;
		 }
		 if(fast.next.next==node) {
			 fast = fast.next;
		 }
		 head1 = node;
		 if(node.next!=node) {
			 head2 = slow.next;
		 }
		 
		 fast.next = slow.next;
		 slow.next = node;
	 }
	 
	 void printList(Node node) {
		 Node temp = node;
		 if(node == null) {
			 return;
		 }
		 
		 while(temp.next != node) {
			 System.out.print(temp.data+" ");
			 temp = temp.next;
		 }
		 System.out.print(temp.data+" ");
	 }
	 
}
