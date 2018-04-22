package stackPrograms;

import java.util.Stack;

public class CheckForBalancedParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] cr = {'{','[','(',')',']','}',')'};
		if(areParenthesisBalanced(cr)) {
			System.out.println("Balanced");
		}else {
			System.out.println("UnBalanced");
		}
	}
	
	static boolean areMatchingPaired(char c1, char c2) {
		if(c1 == '{' && c2 == '}') {
			return true;
		}else if(c1 == '(' && c2 == ')') {
			return true;
		}else if(c1 == '[' && c2 == ']') {
			return true;
		}else {
			return false;
		}
	}
	
	static boolean areParenthesisBalanced(char[] cr) {
		Stack<Character> st = new Stack<>();
		if(cr == null || cr.length == 0) {
			return false;
		}

		for(int i=0; i<cr.length; i++) {
			if(cr[i] == '{' || cr[i] == '(' || cr[i] == '[') {
				st.push(cr[i]);
			}
			
			if(cr[i] == '}' || cr[i] == ')' || cr[i] == ']') {
				if(st.isEmpty()) {
					return false;
				}else if(!areMatchingPaired(st.pop(), cr[i])) {
					return false;
				}
			}
		}
		if(st.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}

}
