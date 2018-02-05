package treePrograms;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class TraversalPrograms {

	
	public List preOrder(TreeNode root){
		List list = new ArrayList();
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(root);
		
		while(!st.isEmpty()){
			TreeNode temp = st.pop();
			list.add(temp.data);
			if(temp.right!=null){
				st.push(temp.right);
			}
			if(temp.left!=null){
				st.push(temp.left);
			}
		}
		return list;
	}
	
	public List inOrder(TreeNode root){
		List list = new ArrayList();
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode curr = root;
		boolean flag = false;
		while(!flag){
			if(curr!=null){
				st.push(curr);
				curr = curr.left;
			}else{
				if(st.isEmpty()){
					flag = true;
				}else{
					TreeNode temp = st.pop();
					list.add(temp.data);
					curr = temp.right;
				}
			}
		}
		return list;
	}
	
	public List postOrder(TreeNode root){
		List list = new ArrayList();
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(root);
		TreeNode prev = null;
		while(!st.isEmpty()){
			TreeNode curr = st.peek();
			if(prev == null || prev.left == curr || prev.right == curr){
				if(curr.left!=null){
					st.push(curr.left);
				}else if(curr.right!=null){
					st.push(curr.right);
				}
			}else if(curr.left == prev){
				if(curr.right!=null){
					st.push(curr.right);
				}
			}else{
				list.add(curr.data);
				st.pop();
			}
			prev = curr;
		}
		return list;
	}
	
	public static void main(String[] args) {
		TraversalPrograms tp = new TraversalPrograms();
		TreeNode tn = TreeNode.getTree();
		System.out.println("\n\n>>>>>>preOrder>>>>>>>>>>"+tp.preOrder(tn));
		System.out.println("\n\n>>>>>>inorder>>>>>>>>>>"+tp.inOrder(tn));
		System.out.println("\n\n>>>>>>postOrder>>>>>>>>>>"+tp.postOrder(tn));
	}

}
