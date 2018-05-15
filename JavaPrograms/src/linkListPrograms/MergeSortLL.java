package linkListPrograms;

import doubleLinkListPrograms.Node;

public class MergeSortLL {
	Node head;
	public static void main(String[] args) {
		MergeSortLL li = new MergeSortLL();
        li.push(15);
        li.push(10);
        li.push(5);
        li.push(20);
        li.push(3);
        li.push(2);
        System.out.println("Linked List without sorting is :");
        li.print(li.head);
 try {
        li.head = li.mergeSort(li.head);
 }catch (Exception e) {
	 e.printStackTrace();
}
        System.out.print("\n Sorted Linked List is: \n");
        li.print(li.head);

	}
	
	Node mergeSort(Node node) {
		if(node == null || node.next == null) {
			return node;
		}
		Node middle = getMiddle(node);
		Node nextToMiddle = middle.next;
		middle.next = null;
		return merge(mergeSort(node),mergeSort(nextToMiddle));
	}
	
	Node merge(Node left, Node right) {
		Node temp = new Node();
		Node fnlList = temp;
		while(left!=null && right!=null) {
			if(left.data<right.data) {
				temp.next = left;
			}else {
				temp.next = right;
			}
			temp = temp.next;
		}
		temp.next = (left==null)?right:left;
		return fnlList.next;
	}

	void push(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
	}
	
	void print(Node node) {
		while(node!=null) {
			System.out.print(node.data+" ");
			node = node.next;
		}
	}
	
	Node getMiddle(Node node) {
		if(node == null)
			return node;
		Node fstPtr = node.next, slwPtr = node;
		while(fstPtr!=null) {
			fstPtr = fstPtr.next;
			if(fstPtr!=null) {
				slwPtr = slwPtr.next;
				fstPtr = fstPtr.next;
			}
		}
		return slwPtr;
	}
}
