package doubleLinkListPrograms;

public class DLL {
	Node head;
	class Node{
		int data;
		Node next,prev;
		Node(int data){
			this.data = data;
		}
	}
	
	public void insertAtBegin(int data) {
		Node temp = new Node(data);
		temp.next = head;
		temp.prev = null;
		if(head!=null)
			head.prev = temp;
		head = temp;
	}
	
	public void insertAfter(Node prevNode, int data) {
		if(prevNode == null) {
			System.out.println("PrevNode is Null");
			return;
		}
		Node temp = new Node(data);
		temp.next = prevNode.next;
		temp.prev = prevNode;
		prevNode.next = temp;
		if(temp.next!=null) {
			temp.next.prev = temp;
		}
	}
	
	public void insertEnd(int data) {
		Node temp = new Node(data);
		temp.next = null;
		if(head == null) {
			temp.prev = null;
			head = temp;
			return;
		}
		Node last = head;
		while(last.next!=null) {
			last = last.next;
		}
		
		last.next = temp;
		temp.prev = last;
	}
	
	public void print(Node node) {
		Node last = null;
		while(node!=null) {
			System.out.print(node.data+" ");
			last = node;
			node = node.next;
		}
		System.out.println();
		/*while(last!=null) {
			System.out.print(last.data+" ");
			last = last.prev;
		}*/
	}
	
	public void deleteNode(Node del) {
		if(head == null || del == null) {
			return;
		}
		if(head == del) {
			head = del.next;
		}
		
		if(del.next!=null) {
			del.next.prev = del.prev;
		}
		
		if(del.prev!=null) {
			del.prev.next = del.next;
		}
	}
	
	public static void main(String[] args) {
        DLL dll = new DLL();
        dll.insertEnd(6);
        dll.insertAtBegin(7);
        dll.insertAtBegin(1);
        dll.insertEnd(4);
        dll.insertAfter(dll.head.next, 8);
        System.out.println("Created DLL is: ");
        dll.print(dll.head);
        dll.deleteNode(dll.head);
        System.out.println("Created DLL is 1: ");
        dll.print(dll.head);
        dll.deleteNode(dll.head.next);
        System.out.println("Created DLL is 2: ");
        dll.print(dll.head);
        dll.deleteNode(dll.head.next.next);
        System.out.println("Created DLL is 3: ");
        dll.print(dll.head);
	}
}
