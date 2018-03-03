package binarySearchTreePrograms;

public class Node {
	public int data;
	Node left , right;
	Node(int key){
		data = key;
		left = right = null;
	}
	Node(){
	}
	public static Node getTree(){
		Node node = new Node(4);
		node.left = new Node(2);
		node.right = new Node(6);
		
		node.left.left = new Node(1);
		node.left.right = new Node(3);
		node.right.left = new Node(5);
		node.right.right = new Node(7);
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
