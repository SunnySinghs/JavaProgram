package binaryTreePrograms;

public class PrintCommonNodes {

	public static void main(String[] args) {
		new PrintCommonNodes().findCommonNodes(new TreeNode().getTree(), 6, 7);

	}
	
	boolean printAncestor(TreeNode node , int target) {
		if(node == null) {
			return false;
		}
		if(node.data == target) {
			System.out.println("\n\n>>>>>>>>"+node.data);
			return true;
		}
		if(printAncestor(node.left, target) || printAncestor(node.right, target)) {
			System.out.println("\n\n>>>>>>>>"+node.data);
			return true;
		}
		return false;
	}
	
	boolean findCommonNodes(TreeNode root, int n1, int n2) {
		TreeNode lca = new LowestCommonAncester().findLCA(root, n1, n2);
		if(lca == null) {
			return false;
		}
		
		printAncestor(root, lca.data);
		return true;
	}

}
