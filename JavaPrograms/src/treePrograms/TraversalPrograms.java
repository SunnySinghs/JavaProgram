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
			TreeNode curr = st.pop();
			if(prev == null || prev.left == curr || prev.right == curr){
				System.out.println("n\n>>>>>>>>00000000000000>>>>>>"+curr.data);
				if(curr.left!=null){
					st.push(curr.left);
					System.out.println("n\n>>>>>>>>11111111>>>>>>"+curr.data);
				}else if(curr.right!=null){
					st.push(curr.right);
					System.out.println("n\n>>>>>>>>22222222>>>>>>"+curr.data);
				}
				System.out.println("n\n>>>>>>>>33333333>>>>>>"+curr.data);
			}else if(curr.left == prev){
				if(curr.right!=null){
					st.push(curr.right);
					System.out.println("n\n>>>>>>>>444444>>>>>>"+curr.data);
				}
				System.out.println("n\n>>>>>>>>55555555555>>>>>>"+curr.data);
			}else{
				System.out.println("n\n>>>>>>>>66666666>>>>>>"+curr.data);
				list.add(curr.data);
				st.pop();
				System.out.println("n\n>>>>>>>>777777777>>>>>>"+curr.data);
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
