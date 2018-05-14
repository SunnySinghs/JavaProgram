package doubleLinkListPrograms;

import doubleLinkListPrograms.Node;

public class QuickSort {
	Node head;
	public static void main(String[] args) {
		QuickSort list = new QuickSort();
		list.push(5);
        list.push(20);
        list.push(4);
        list.push(3);
        list.push(30);

        System.out.println("Linked List before sorting ");
        list.printList(list.head);
        System.out.println("\nLinked List after sorting");
        list.quickSort(list.head);
        list.printList(list.head);
     

	}
	
	Node partition(Node start, Node last) {
		int x = last.data;
		Node i = start.random;
		for(Node j = start; j!=last; j = j.next) {
			if(j.data<=x) {
				i = (i==null)?start:i.next;
				int temp = i.data;
				i.data = j.data;
				j.data = temp;
			}
		}
		i = (i==null)?start:i.next;
		int temp = i.data;
		i.data = last.data;
		last.data = temp;
		return i;
	}
	
	public void printList(Node head)
    {
       while(head!=null){
           System.out.print(head.data+" ");
           head = head.next;
       }
   }

	void _quickSort(Node start, Node last){
		if(last!=null && last!=start && start!=last.next) {
			Node node = partition(start, last);
			_quickSort(start, node.random);
			_quickSort(node.next, last);
		}
	}
	
	void quickSort(Node start) {
		Node last = getLastNode(start);
		_quickSort(start, last);
	}
	
	void push(int data) {
		Node node = new Node(data);
		if(head == null) {
			head = node;
			return;
		}
		node.next = head;
		head.random = node;
		node.random = null;
		head = node;
	}
	
	Node getLastNode(Node temp) {
		if(temp==null) {
			return null;
		}
		while(temp.next!=null) {
			temp = temp.next;
		}
		return temp;
	}
}
