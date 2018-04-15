package queuePrograms;

import java.util.Stack;

public class QueueUsingFunctionStack 
{
	static class Queue
	{
		Stack<Integer> stack1;
	}

	static void push(Stack<Integer> top_ref,int new_data)
	{
		top_ref.push(new_data);
	}

	static int pop(Stack<Integer> top_ref)
	{
		if(top_ref == null)
		{
			System.out.println("Stack Overflow");
			System.exit(0);    
		}
		return top_ref.pop(); 
	}

	static void enQueue(Queue q,int x)
	{
		push(q.stack1,x);
	}

	static int deQueue(Queue q)
	{
		int x,res=0;
		if(q.stack1.isEmpty())
		{
			System.out.println("Q is Empty");
			System.exit(0);
		}
		else if(q.stack1.size() == 1)
		{
			return pop(q.stack1);
		}
		else
		{
			x=pop(q.stack1);
			System.out.println("X === "+x);
			res = deQueue(q);
			System.out.println("res === "+res);
			System.out.println("X === "+x);
			push(q.stack1,x);
			System.out.println("res === 111>>"+res);
			return res;
		}
		return 0;
	}

	public static void main(String[] args) 
	{
		Queue q = new Queue();
		q.stack1 = new Stack<>();

		enQueue(q, 1);
		enQueue(q, 2);
		enQueue(q, 3);

		System.out.println(deQueue(q) + " AAA ");
		System.out.println(deQueue(q) + " BBB ");
		System.out.println(deQueue(q) + " CCC ");

	}
}
