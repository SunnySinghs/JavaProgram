package doubleLinkListPrograms;

public class CountTripletsDLL {

	public static void main(String[] args) {
		Node head = null;
		InsertInSortedDLL list = new InsertInSortedDLL();
		head = list.insertNode(head, new Node(1));
		//head = list.insertNode(head, new Node(3)); 
		head = list.insertNode(head, new Node(2));
		head = list.insertNode(head, new Node(5));
		head = list.insertNode(head, new Node(4));
		head = list.insertNode(head, new Node(6));
		head = list.insertNode(head, new Node(8));
		head = list.insertNode(head, new Node(9));
		list.print(head);
		System.out.println();
		System.out.println("Count : "+new CountTripletsDLL().countTriplet(head, 17));

	}
	
	int countPairs(Node first, Node second, int data) {
		int count = 0;
		while(first!=null && second!=null && first!=second && second.next!=first) {
			if((first.data+second.data) == data) {
				count++;
				first = first.next;
				second = second.random;
			}else if((first.data+second.data) > data) {
				second = second.random;
			}else {
				first = first.next;
			}
		}
		return count;
	}
	
	int countTriplet(Node head, int x) {
		if(head == null) {
			return 0;
		}
		int count = 0;
		Node curr, first, last;
		last = head;
		while(last.next!=null)
			last = last.next;
		
		for(curr = head; curr!=null; curr= curr.next) {
			first = curr.next;
			count += countPairs(first, last, x-curr.data);
		}
		
		return count;
	}

}
