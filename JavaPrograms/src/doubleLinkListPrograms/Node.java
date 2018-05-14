package doubleLinkListPrograms;

public class Node {
	public int data;
	public Node next;
	public Node random;
	public Node(int data){
		this.data = data;
		this.next = this.random = null;
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
