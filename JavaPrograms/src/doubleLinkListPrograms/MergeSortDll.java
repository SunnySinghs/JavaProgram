package doubleLinkListPrograms;

public class MergeSortDll {
	static Node head ;
	public static void main(String[] args) {
		MergeSortDll list = new MergeSortDll();
        list.head = new Node(10);
        list.head.next = new Node(30);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(20);
        list.head.next.next.next.next.next = new Node(5);
         
        /*System.out.println("Linked list before sorting :");
        list.print(head);*/
        Node node = list.mergeSort(head);
        System.out.println("Linked list after sorting :");
        list.print(node);
	}
	
	Node getMiddle(Node node) {
		Node first = node, second = node;
		while(second.next!=null && second.next.next!=null) {
			first = first.next;
			second = second.next.next;
		}
		Node temp = first.next;
		first.next = null;
		return temp;
	}

	void print(Node node) {
        Node temp = node;
        System.out.println("Forward Traversal using next pointer");
        while (node != null) {
            System.out.print(node.data + " ");
            temp = node;
            node = node.next;
        }
        System.out.println("\nBackward Traversal using prev pointer");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.random;
        }
    }
	
	Node mergeSort(Node node) {
		if(node == null || node.next == null) {
			return node;
		}
		Node second = getMiddle(node);
		
		node = mergeSort(node);
		second = mergeSort(second);
		return merge(node, second);
	}

	private Node merge(Node node, Node second) {
		if(node == null) {
			return second;
		}
		if(second == null) {
			return node;
		}
		
		if(node.data<second.data) {
			node.next = merge(node.next, second);
			node.next.random = node;
			node.random = null;
			return node;
		}else {
			second.next = merge(node, second.next);
			second.next.random = second;
			second.random = null;
			return second;
		}
	}
}
