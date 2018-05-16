package doubleLinkListPrograms;

import doubleLinkListPrograms.Node;
import linkListPrograms.MergeSortLL;

public class PairSumDLL {
	Node head;
	public static void main(String[] args) {
		PairSumDLL li = new PairSumDLL();
		li.push(9);
		li.push(8);
		li.push(6);
		li.push(5);
		li.push(4);
		li.push(3);
		li.push(2);
		li.push(1);
		li.pairSum(li.head, 8);
	}

	public void push(int data) {
		Node temp = new Node(data);
		temp.next = head;
		temp.random = null;
		if(head!=null)
			head.random = temp;
		head = temp;
	}
	
	void pairSum(Node node, int x) {
		if(node == null) {
			return;
		}
		Node first = node;
		Node second = node;
		while(second.next!=null) {
			second = second.next;
		}
		boolean found = false;
		while(first!=null && second!=null && first != second && second.next!=first) {
			if((first.data+second.data) == x) {
				found = true;
				System.out.println("Pair ("+first.data+","+second.data+")");
				first = first.next;
				second = second.next;
			}else {
				if((first.data+second.data)<x) {
					first = first.next;
				}else {
					second = second.random;
				}
			}
		}
		if(!found) {
			System.out.println("Not Found");
		}
	}
}
