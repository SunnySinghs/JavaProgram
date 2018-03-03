package binaryTreePrograms;

public class TreeNode {
	public int data;
	TreeNode left , right;
	TreeNode(int key){
		data = key;
		left = right = null;
	}
	TreeNode(){
	}
	public static TreeNode getTree(){
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(7);
		/*node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		
		node.left.right = new TreeNode(4);
		node.right.left = new TreeNode(5);
		node.left.right.left = new TreeNode(6);
		node.right.left.right = new TreeNode(7);
		node.right.left.right.left = new TreeNode(8);*/
		return node;
	}
}
