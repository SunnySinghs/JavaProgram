package linkListPrograms;

public class LinkListOperations {

	Node head;
	class Node {
		int data;
		Node next;
		Node(int n){
			data = n;
			next = null;
		}
	}
	void insert(int data) {
		Node node  = new Node(data);
		node.next = head;
		head = node;
	}
	
	void insertafter(Node prev_node, int data) {
		if(prev_node == null) {
			System.out.println("previous node can't be null");
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
	
	void printlist() {
		Node node = head;
		while(node!=null) {
			System.out.print(node.data+" ");
			node = node.next;
		}
	}
	
	void deleteNode(int key) {
		Node temp = head, prev = null; 
		if(temp!=null && temp.data==key) {
			head = temp.next;
			return;
		}
		while(temp!=null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}
		
		if(temp == null) return;
		
		prev.next = temp.next;
		
	}
	
	public static void main(String[] args) {
		LinkListOperations llist = new LinkListOperations();
        llist.append(6);
        llist.insert(7);
        llist.insert(1);
        llist.append(4);
        llist.insertafter(llist.head.next, 8);
        llist.deleteNode(4);
        System.out.println("\ncreated linked list is: ");
        llist.printlist();
	}
}
