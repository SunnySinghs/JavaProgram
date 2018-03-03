package binaryTreePrograms;

public class SizeOfTree {

	public int sizeOfTree(TreeNode root) {
		if(root == null) {
			return 0;
		}else {
			return (sizeOfTree(root.left) + 1 + sizeOfTree(root.right));
		}
	}
	public static void main(String[] args) {
		TreeNode tn = new TreeNode().getTree();
		System.out.println("Size of Tree>>>>>>>>>>"+new SizeOfTree().sizeOfTree(tn));

	}

}
