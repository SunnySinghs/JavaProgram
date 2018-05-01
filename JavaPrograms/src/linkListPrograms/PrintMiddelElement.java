package linkListPrograms;

import linkListPrograms.LinkListOperations.Node;

public class PrintMiddelElement {

	public static void main(String[] args) {
		LinkListOperations llist = new LinkListOperations();
        llist.append(6);
        llist.insert(7);
        llist.insert(1);
        llist.insert(5);
        llist.append(4);
        llist.insertafter(llist.head.next, 8);
        printMiddelElement(llist);
	}
	
	static void printMiddelElement(LinkListOperations llo) {
		int count = 0;
		llo.printlist();
		Node temp = llo.head, node = null;
		while(temp!=null) {
			count++;
			temp = temp.next;
		}
		temp = llo.head;
		count = (int) Math.floor(count/2);
		for(int i=0; i<=count; i++) {
			node = temp;
			temp = temp.next;
		}
		System.out.println();
		System.out.println(node.data);
	}
}
