package doubleLinkListPrograms;

import java.util.HashMap;
import java.util.LinkedList;

import doubleLinkListPrograms.Node;

public class CopyRandomDLL {
	
	Node head;
	
	 public CopyRandomDLL(Node head) {
		this.head = head;
	}
	public static void main(String[] args) {
		CopyRandomDLL crdll = new CopyRandomDLL(new Node(5));
		crdll.push(6);
		crdll.push(7);
		crdll.push(8);
		crdll.push(9);
		
		crdll.head.random = crdll.head.next.next;
		crdll.head.next.random =
				crdll.head.next.next.next;
		crdll.head.next.next.random =
				crdll.head.next.next.next.next;
		crdll.head.next.next.next.random =
				crdll.head.next.next.next.next.next;
		crdll.head.next.next.next.next.random =
				crdll.head.next;
		CopyRandomDLL clone  = crdll.clone();
		System.out.println("Origional list:");
		crdll.print();
		System.out.println("Copy list:");
		clone.print();
	}
	
	public void push(int data) {
		Node node = new Node(data);
		node.next = this.head;
		head = node;
	}
	
	void print() {
		Node temp = head;
		while(temp!=null) {
			Node random = temp.random;
			int randomData = (random!=null)?random.data:-1;
			System.out.println("data : "+temp.data+" randomData:"+randomData);
			temp = temp.next;
		}
	}

	public CopyRandomDLL clone() {
		Node orgCurr = this.head, clnCurr = null;
		HashMap<Node,Node> hmap = new HashMap<Node, Node>();
		while(orgCurr!=null) {
			clnCurr = new Node(orgCurr.data);
			hmap.put(orgCurr, clnCurr);
			orgCurr = orgCurr.next;
		}
		
		orgCurr = this.head;
		while(orgCurr!=null) {
			clnCurr = hmap.get(orgCurr);
			clnCurr.next = hmap.get(orgCurr.next);
			clnCurr.random = hmap.get(orgCurr.random);
			orgCurr = orgCurr.next;
		}
		
		return new CopyRandomDLL(hmap.get(this.head));
	}
}
