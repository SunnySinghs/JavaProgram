package doubleLinkListPrograms;

import java.util.HashMap;
import java.util.LinkedList;

import doubleLinkListPrograms.DLL.Node;

public class CopyRandomDLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public LinkedList clone(DLL dll) {
		Node orgCurr = dll.head, clnCurr = null;
		HashMap<Node,Node> hmap = new HashMap<Node, Node>();
		while(orgCurr!=null) {
			clnCurr = orgCurr.next;
			hmap.put(orgCurr, clnCurr);
			orgCurr = orgCurr.next;
		}
		
		orgCurr = dll.head;
		while(orgCurr!=null) {
			clnCurr = hmap.get(orgCurr);
			clnCurr.next = hmap.get(orgCurr.next);
			clnCurr.prev = hmap.get(orgCurr.prev);
			orgCurr = orgCurr.next;
		}
		
		return new LinkedList(hmap.get(dll.head));
	}
}
