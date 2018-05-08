package doubleLinkListPrograms;

import doubleLinkListPrograms.DLL.Node;

public class ReverseDLL {

	public static void main(String[] args) {
		DLL dll = new DLL();
        dll.insertEnd(6);
        dll.insertAtBegin(7);
        dll.insertAtBegin(1);
        dll.insertEnd(4);
        dll.insertAfter(dll.head.next, 8);
        dll.print(dll.head);
        reverseDLL(dll);
        dll.print(dll.head);
	}
	
	public static void reverseDLL(DLL dll) {
		Node current = dll.head, temp = null;
		if(current!=null) {
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.next;
		}
		if(temp!=null) {
			dll.head = temp.prev;
		}
	}

}
