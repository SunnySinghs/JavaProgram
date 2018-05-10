package doubleLinkListPrograms;

public class Node {
	int data;
	Node next , random;
	Node(int data){
		this.data = data;
		this.next = this.random = null;
	}
}
