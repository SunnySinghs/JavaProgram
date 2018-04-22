package stackPrograms;

import java.util.Stack;

public class SortStackElements {
	public static void main(String[] args) {
		 Stack<Integer> s = new Stack<>();
	        s.push(30);
	        s.push(-5);
	        s.push(18);
	        s.push(14);
	        s.push(-3);
	        SortElement(s);
	        System.out.println(s);

	}
	
	static void SortElement(Stack<Integer> st) {
		if(!st.isEmpty()) {
			int element = st.pop();
			SortElement(st);
			sortStack(st,element);
		}
	}
	
	static void sortStack(Stack<Integer> st, int ele) {
		if(st.isEmpty() || ele>st.peek()) {
			st.push(ele);
			return;
		}
		int temp = st.pop();
		sortStack(st, ele);
		st.push(temp);
	}

}
