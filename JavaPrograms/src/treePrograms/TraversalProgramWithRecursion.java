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
	
	public void levelOrder(TreeNode root) {
		int h = new HeightOfTree().heightOfTree(root);
		for(int i=1;i<=h;i++) {
			printGivenLevel(root,i);
		}
		
	}
	public void printGivenLevel(TreeNode root, int level) {
		if(root == null) {
			return;
		}
		if(level == 1) {
			System.out.print(root.data+" ");
		}else {
			printGivenLevel(root.left, level-1);
			printGivenLevel(root.right, level-1);
		}
	}
	public static void main(String[] args) {
		TreeNode tn = new TreeNode().getTree();
		TraversalProgramWithRecursion tpwr = new TraversalProgramWithRecursion();
		tpwr.preOrder(tn);
		System.out.println();
		tpwr.inOrder(tn);
		System.out.println();
		tpwr.postOrder(tn);
		System.out.println();
		tpwr.levelOrder(tn);
	}

}
