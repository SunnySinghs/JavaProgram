package treePrograms;

public class TraversalProgramWithRecursion {

	public void preOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void inOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	
	public void postOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}
	public static void main(String[] args) {
		TreeNode tn = new TreeNode().getTree();
		TraversalProgramWithRecursion tpwr = new TraversalProgramWithRecursion();
		tpwr.preOrder(tn);
		System.out.println();
		tpwr.inOrder(tn);
		System.out.println();
		tpwr.postOrder(tn);
	}

}
