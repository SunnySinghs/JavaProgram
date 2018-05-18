package doubleLinkListPrograms;

public class InsertInSortedDLL {

	public static void main(String[] args) {
		Node head = null;
		InsertInSortedDLL list = new InsertInSortedDLL();
		head = list.insertNode(head, new Node(1));
		head = list.insertNode(head, new Node(3)); 
		head = list.insertNode(head, new Node(2));
		head = list.insertNode(head, new Node(5));
		head = list.insertNode(head, new Node(4));
		head = list.insertNode(head, new Node(6));
		head = list.insertNode(head, new Node(8));
		head = list.insertNode(head, new Node(4));
		head = list.insertNode(head, new Node(7));
		list.print(head);
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
	Node insertNode(Node head, Node node) {
		if(node == null) {
			return node;
		}
		if(head == null) {
			head = node;
		}else if(head.data>=node.data){
			node.next = head;
			node.next.random = node;
			head = node;
		}else {
			Node curr = head;
			while(curr.next!=null && node.data>curr.next.data) {
				curr = curr.next;
			}
			node.next = curr.next;
			if(curr.next!=null)
				curr.next.random = node;
			curr.next = node;
			node.random = curr;
			
		}
		return head;
	}
}
