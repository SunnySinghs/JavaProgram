package linkListPrograms;

import linkListPrograms.LinkListOperations.Node;

public class ReverseLinkList {

	public static void main(String[] args) {
		LinkListOperations llist = new LinkListOperations();
        llist.append(6);
        llist.insert(7);
        llist.insert(1);
        llist.insert(5);
        llist.append(4);
        llist.insertafter(llist.head.next, 8);
        llist.printlist();
        Node node = reverseLinkList(llist.head);
        System.out.println();
        print(node);
	}
	static void print(Node node) {
		while(node!=null){
			System.out.print(node.data+" ");
			node = node.next;
		}
	}
	static Node reverseLinkList(Node node) {
		Node prev = null, current = node, next = null;
		while(current!=null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}

}
