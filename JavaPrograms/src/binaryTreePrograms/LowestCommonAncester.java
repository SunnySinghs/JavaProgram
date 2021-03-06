package binaryTreePrograms;

public class LowestCommonAncester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LowestCommonAncester lcs = new LowestCommonAncester();
		TreeNode node = new TreeNode().getTree();
		TreeNode lca = lcs.findLCA(node, 4, 6);
		if(lca!=null) {
			System.out.println("\n\n>>>>6,7>>>>>>>>"+lca.data);
		}else {
			System.out.println("\n\n>>>>6,7>>>>>>>>>Keys are not prsent");
		}

	}
	boolean v1 = false, v2 = false;
	TreeNode findLCAUtil(TreeNode root,int n1,int n2) {
		if(root == null) {
			return root;
		}
		
		if(root.data == n1) {
			v1 = true;
			return root;
		}
		
		if(root.data == n2) {
			v2 = true;
			return root;
		}
		System.out.println("\n\n>>>>>>"+root.data);
		TreeNode leftLCA = findLCAUtil(root.left, n1, n2);
		System.out.println("\n\n>>>>>leftLCA>>>>>"+leftLCA);
		if(leftLCA != null) {
			System.out.println("\n\n>>>>>leftLCA.data>>>>"+leftLCA.data);
		}
		TreeNode rightLCA = findLCAUtil(root.right, n1, n2);
		System.out.println("\n\n>>>>>rightLCA>>>>>"+rightLCA);
		if(rightLCA != null) {
			System.out.println("\n\n>>>>>rightLCA.data>>>>"+rightLCA.data);
		}
		
		if(leftLCA !=null && rightLCA!=null) {
			return root;
		}
		System.out.println("\n\n>>>>>>Both NUll>>>>>>>>");
		return (leftLCA!=null)?leftLCA:rightLCA;
	}
	TreeNode findLCA(TreeNode node, int n1, int n2) {
		v1 = false;
		v2 = false;
		TreeNode root = findLCAUtil(node, n1, n2);
		if(v1 && v2) {
			return root;
		}
		return null;
	}
}
