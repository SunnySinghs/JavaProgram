package stackPrograms;

import java.util.Stack;

public class ReverseStack {

	static int item;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> st = new Stack();
		for(int i=0; i<5; i++) {
			st.push(i);
		}
		System.out.println(st);
		reverseStack(st);
		System.out.println(st);
	}
	
	static void reverseStack(Stack<Integer> st) {
		if(st.isEmpty()) {
			return;
		}else {
			int ele = st.pop();
			reverseStack(st);
			insertAtBottom(st, ele);
		}
	}
	
	static void insertAtBottom(Stack<Integer> st,int x) {
		int item;
		if(st.isEmpty()) {
			st.push(x);
		}else {
			item = st.pop();
			insertAtBottom(st, x);
			st.push(item);
		}
	}

}
