package treePrograms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveLeafNode {

	public static void main(String[] args) {
		List<Integer> al = new RemoveLeafNode().removeLeafNodeBT(new TreeNode().getTree());
		System.out.println(al);

	}
	
	List<Integer> removeLeafNodeBT(TreeNode node){
		List<Integer> al = new ArrayList<Integer>();
		Stack<TreeNode> st = new Stack<TreeNode>();
		if(node == null){
			return al;
		}
		TreeNode curr = node;
		st.push(curr);
		while(!st.isEmpty()){
			curr = st.pop();
			if(curr.left == null && curr.right == null){
				
			}else{
				al.add(curr.data);
			}
			if(curr.right!=null){
				st.push(curr.right);
			}
			if(curr.left!=null){
				st.push(curr.left);
			}
		}
		return al;
		
	}

}
