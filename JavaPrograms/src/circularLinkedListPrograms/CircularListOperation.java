package circularLinkedListPrograms;

import doubleLinkListPrograms.Node;

public class CircularListOperation {

	public static void main(String[] args) {
		CircularListOperation opp = new CircularListOperation();
		Node last = null;
		last = opp.addToEmpty(last, 6);
	    last = opp.addInStart(last, 4);
	    last = opp.addInStart(last, 2);
	    last = opp.addInEnd(last, 8);
	    last = opp.addInEnd(last, 12);
	    last = opp.insertINbtw(last, 10, 8);
	    opp.printList(last);
	}

	Node addToEmpty(Node last,int data) {
		Node node = new Node(data);
		if(last == null) {
			last = node;
			node.next = last;
		}
		return last;
	}
	
	Node addInStart(Node last, int data) {
		if(last == null) {
			addInEnd(last, data);
		}
		Node node = new Node(data);
		node.next = last.next;
		last.next = node;
		return last;
	}
	
	Node addInEnd(Node last, int data) {
		if(last == null) {
			addInEnd(last,data);
		}
		Node node = new Node(data);
		node.next = last.next;
		last.next = node;
		last = node;
		return last;
	}
	
	Node insertINbtw(Node last, int data, int n) {
		if(last == null) {
			addInEnd(last,data);
		}
		Node p = last.next;
		while(p.data!=n) {
			p = p.next;
		}
		if(p == last.next) {
			System.out.println("data not found");
			return last;
		}
		Node node = new Node(data);
		node.next = p.next;
		p.next = node;
		if(p==last) {
			last = node;
		}
		return last;
	}
	
	void printList(Node node) {
		 Node temp = node;
		 if(node == null) {
			 return;
		 }
		 Node p = node.next;
		 do {
			 System.out.print(p.data+" ");
			 p = p.next;
		 }while(p!=node.next);
	 }
	
}
