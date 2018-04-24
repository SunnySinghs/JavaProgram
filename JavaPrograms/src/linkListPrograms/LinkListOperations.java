package linkListPrograms;

public class LinkListOperations {

	Node head;
	class Node {
		int data;
		Node next;
		Node(int n){
			this.data = n;
		}
	}
	void insert(int data) {
		Node node  = new Node(data);
		node.next = head;
		head = node;
	}
	
	void insertAfter(Node prev_node, int data) {
		if(prev_node == null) {
			System.out.println("Previous node can't be null");
			return;
		}
		Node node = new Node(data);
		node.next = prev_node.next;
		prev_node.next = node;
	}
	
	void append(int data) {
		Node node  = new Node(data);
		if(head == null) {
			head = new Node(data);
			return;
		}
		node.next = null;
		Node last = head;
		while(last.next!=null)
			last = last.next;
		last.next = node;
		return;
	}
	
	void printList() {
		Node node = head;
		while(node.next!=null) {
			System.out.println(node.data+" ");
		}
	}
	
	public static void main(String[] args) {
		LinkListOperations llist = new LinkListOperations();
		 
        llist.append(6);
 
        llist.insert(7);
 
        llist.insert(1);
 
        llist.append(4);
 
        llist.insertAfter(llist.head.next, 8);
 
        System.out.println("\nCreated Linked list is: ");
        llist.printList();

	}

}
