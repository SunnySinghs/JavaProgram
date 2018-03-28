package queuePrograms;

import java.util.Stack;

public class QueueFromStack {

	static class Queue{
		Stack<Integer> s1;
		Stack<Integer> s2;
		
	}
	
	static void push(Stack<Integer> st, int item) {
		st.push(item);
	}
	
	static int pop(Stack<Integer> st) {
		if(st.isEmpty()) {
			System.out.println("Stack is Empty");
			System.exit(0);
		}
		return st.pop();
	}
	
	static void enqueue(Queue q, int item) {
		push(q.s1,item);
	}
	
	static int dequeue(Queue q) {
		int x;
		if(q.s1.isEmpty() && q.s2.isEmpty()) {
			System.out.println("Q is Empty");
			System.exit(0);
		}
		
		if(q.s2.isEmpty()) {
			while(!q.s1.isEmpty()) {
				x = pop(q.s1);
				push(q.s2, x);
			}
		}
		return q.s2.pop();
	}
	
	public static void main(String[] args) {
		Queue q= new Queue();
        q.s1 = new Stack<>();
        q.s2 = new Stack<>();
        enqueue(q, 1);
        enqueue(q, 2);
        enqueue(q, 3);
         
        System.out.print(dequeue(q)+" ");
        System.out.print(dequeue(q)+" ");
        System.out.println(dequeue(q)+" ");

	}


}
