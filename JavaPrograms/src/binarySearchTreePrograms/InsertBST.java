package binarySearchTreePrograms;

import binaryTreePrograms.TraversalProgramWithRecursion;

public class InsertBST {

	public static void main(String[] args) {
		Node node = new InsertBST().insertInBST(new Node().getTree(), 8);
		new InsertBST().preOrder(node);

	}
	Node root;
	Node insertRec(int value) {
		root = null;
		return insertInBST(root, value);
	}
	Node insertInBST(Node root, int value) {
		if(root == null) {
			root = new Node(value);
			return root;
		}
		if(root.data<value) {
			root.right = insertInBST(root.right, value);
		}else if(root.data>value){
			root.left = insertInBST(root.left, value);
		}
		return root;
	}
	
	 void preOrder(Node root) {
	        if (root != null) {
	        	preOrder(root.left);
	        	System.out.println(root.data);
	        	preOrder(root.right);
	        }
	    }
}
