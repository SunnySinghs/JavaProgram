package treePrograms;

public class MaximumOfTree {

	public int maximumOfTree(TreeNode root) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		int res = root.data;
		int lm = maximumOfTree(root.left);
		int rm = maximumOfTree(root.right);
		
		if(lm>res) {
			res = lm;
		}
		if(rm>res) {
			res = rm;
		}
		return res;
	}
	public static void main(String[] args) {
		TreeNode tn = new TreeNode().getTree();
		System.out.println("Maximum in Tree>>>>>>"+new MaximumOfTree().maximumOfTree(tn));

	}

}
