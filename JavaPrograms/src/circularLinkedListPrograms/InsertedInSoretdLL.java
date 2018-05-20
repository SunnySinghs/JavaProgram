package circularLinkedListPrograms;

import doubleLinkListPrograms.Node;

public class InsertedInSoretdLL {

	Node head;
	public static void main(String[] args) {
 
        int arr[] = new int[] {12, 56, 2, 11, 1, 90};
        InsertedInSoretdLL list = new InsertedInSoretdLL();
 
        for (int i = 0; i < 6; i++)
        {
            list.insertInSLL(arr[i]);
        }
 
        list.printList();

	}
	
	 void printList()
	 {
		 if (head != null)
		 {
			 Node temp = head;
			 do
			 {
				 System.out.print(temp.data + " ");
				 temp = temp.next;
			 }  while (temp != head);
		 }
	 }
	 
	void insertInSLL(int data) {
		Node node = new Node(data);
		Node current = head;
		if(current == null) {
			node.next = node;
			head = node;
		}else if(current.data>=node.data) {
			while(current.next!=head) {
				current=current.next;
			}
			node.next=current.next;
			current.next=node;
			head=node;
		}else {
			while(current.next!=head && current.next.data<node.data){
				current=current.next;
			}
			node.next=current.next;
			current.next=node;
		}
	}

}
