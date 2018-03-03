package binaryTreePrograms;

public class HeightOfTree {

	public int heightOfTree(TreeNode root) {
		if(root == null) {
			return 0;
		}else {
			int lHeight = heightOfTree(root.left);
			int rHeight = heightOfTree(root.right);
			if(lHeight>rHeight) {
				return ++lHeight;
			}else {
				return ++rHeight;
			}
		}
	}
	public static void main(String[] args) {
		TreeNode node = new TreeNode().getTree();
		HeightOfTree ht = new HeightOfTree();
		System.out.println("\n\n>>Height of Tree>>>>"+ht.heightOfTree(node));
	}

}
	