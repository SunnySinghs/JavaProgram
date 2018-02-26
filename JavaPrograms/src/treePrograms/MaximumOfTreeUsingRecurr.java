package treePrograms;

import java.util.Stack;

public class MaximumOfTreeUsingRecurr {

	public int MOT(TreeNode root) {
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode curr = root;
		st.push(curr);
		if(curr == null) {
			return Integer.MIN_VALUE;
		}
		int max = 0;
		while(!st.isEmpty()) {
			curr = st.pop();
			if(max<curr.data) {
				max = curr.data;
			}
			if(curr.right!=null) {
				st.push(curr.right);
			}
			if(curr.left!=null) {
				st.push(curr.left);
			}
		}
		return max;
	}
	public static void main(String[] args) {
		TreeNode node = new TreeNode().getTree();
		int max = new MaximumOfTreeUsingRecurr().MOT(node);
		System.out.println(max);
	}

}
