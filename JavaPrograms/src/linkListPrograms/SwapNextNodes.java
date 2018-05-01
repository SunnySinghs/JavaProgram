package linkListPrograms;

import java.util.LinkedList;
import linkListPrograms.LinkListOperations.Node;

public class SwapNextNodes {

	public static void main(String[] args) {
		LinkListOperations llist = new LinkListOperations();
        llist.append(6);
        llist.insert(7);
        llist.insert(1);
        llist.append(4);
        llist.insertafter(llist.head.next, 8);
        //swapNextNodes(llist,7,6);
        swapNodes(llist,7,6);
	}
	
	static void swapNextNodes(LinkListOperations llo, int n1, int n2) {
		Node temp = llo.head, prev1 = null, prev2 = null, node1 = null, node2 = null, node3 = null, node4 = null;
		while(temp!=null) {
			if(temp.data == n1) {
				prev1 = temp;
			}
			if(temp.data == n2) {
				prev2 = temp;
			}
			temp = temp.next;
		}
		if(prev1 == null || prev2 == null) {
			System.out.println("Element doesn't exist in List");
		}
		llo.printlist();
		System.out.println();
		node1 = prev1.next;
		node2 = prev2.next;
		node3 = prev1.next.next;
		node4 = prev2.next.next;
		prev1.next = node2;
		node2.next = node3;
		prev2.next = node1;
		node1.next = node4;
		
		llo.printlist();
	}
	
	static void swapNodes(LinkListOperations llo, int n1, int n2) {
		Node temp = llo.head, prev1 = null, prev2 = null, node1 = null, node2 = null, node3 = null, node4 = null;
		//while(temp!=null) {
			while(temp.data != n1) {
				prev1 = temp;
				temp = temp.next;
			}
			while(temp.data != n2) {
				prev2 = temp;
				temp = temp.next;
			}
			
		//}
		if(prev1 == null || prev2 == null) {
			System.out.println("Element doesn't exist in List");
		}
		System.out.println(prev1.data + " " + prev2.data);
		llo.printlist();
		System.out.println();
		node1 = prev1.next;
		node2 = prev2.next;
		if(prev1.next!=null)
		node3 = prev1.next.next;
		if(prev2.next!=null)
		node4 = prev2.next.next;
		prev1.next = node2;
		if(node2!=null)
		node2.next = node3;
		prev2.next = node1;
		if(node1!=null)
		node1.next = node4;
		
		llo.printlist();
	}

}
