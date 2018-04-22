package stackPrograms;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		int arr[] = { 11, 13, 21, 3 };
        int n = arr.length;
        printGreater(arr, n);
	}
	
	static void printGreater(int[] arr, int n) {
		if(arr == null || arr.length == 0) {
			return;
		}
		Stack<Integer> st = new Stack();
		st.push(arr[0]);
		int next,element;
		
		for(int i=1; i<arr.length; i++) {
			next = arr[i];
			if(st.empty() == false) {
				element = st.pop();
				while (element < next) {
					System.out.println(element+"--->"+next);
					if(st.isEmpty()) {
						break;
					}
					element = st.pop();
				}
				if(element>next) {
					st.push(element);
				}
			}
			st.push(next);
		}
		
		while(st.isEmpty() == false) {
			element = st.pop();
			next = -1;
			System.out.println(element+"--->-1");
		}
	}
}
