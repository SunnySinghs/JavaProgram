package queuePrograms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InterleaveQueueElement {

	public static void main(String[] args) {
		Queue queue = new LinkedList<Integer>();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);
		queue.add(60);
		queue.add(70);
		queue.add(80);
		queue.add(90);
		queue.add(100);
		
		interLeaveQueue(queue);
	}
	
	static void interLeaveQueue(Queue<Integer> q) {
		if(q.size()%2 != 0) {
			System.out.println("Please enter even number of integers.");
		}
		
		Stack<Integer> s = new Stack<Integer>();
		int halfSize = q.size()/2;
		
		for(int i=0; i<halfSize; i++) {
			s.add(q.peek());
			q.remove();
		}
		
		while(!s.isEmpty()) {
			q.add(s.peek());
			s.pop();
		}
		
		for(int i=0; i<halfSize; i++) {
			q.add(q.peek());
			q.remove();
		}
		
		for(int i=0; i<halfSize; i++) {
			s.add(q.peek());
			q.remove();
		}
		
		while(!s.isEmpty()) {
			q.add(s.peek());
			s.pop();
			q.add(q.peek());
			q.remove();
		}
		
		while(!q.isEmpty()) {
			System.out.print(q.peek() + " ");
			q.remove();
		}
	}
}
