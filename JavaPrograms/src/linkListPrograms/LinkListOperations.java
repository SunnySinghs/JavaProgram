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
	
	void deleteNodeAtGivenPosition(int pos) {
		Node temp = head, prev = null;
		if(pos == 0) {
			head = temp.next;
			return;
		}
		for(int i = 0; temp!=null && i<pos; i++) {
			prev = temp;
			temp = temp.next;
		}
		if(temp == null) return;
		prev.next = temp.next;
	}
	
	void deleteNodeAtLastOccurence(int key) {
		Node temp = head, x=null;
		while(temp!=null) {
			if(temp!=null && temp.data == key) {
				x = temp;
			}
			temp = temp.next;
		}
		if(x!=null && x.next!=null) {
			x.data = x.next.data;
			x.next = x.next.next;
		}else {
			Node node = head;
			while(node.next!=x) {
				node = node.next;
			}
			node.next = null;
		}
	}
	
	public static void main(String[] args) {
		LinkListOperations llist = new LinkListOperations();
        llist.append(6);
        llist.insert(7);
        llist.insert(1);
        //llist.append(1);
        llist.append(4);
        llist.insertafter(llist.head.next, 8);
        System.out.println("\ncreated linked list is: ");
        llist.printlist();
        llist.deleteNode(4);
        System.out.println("\ncreated linked list is: ");
        llist.printlist();
        llist.deleteNodeAtGivenPosition(2);
        System.out.println("\ncreated linked list is: ");
        llist.printlist();
        llist.deleteNodeAtLastOccurence(1);
        System.out.println("\ncreated linked list is: ");
        llist.printlist();
	}
}
