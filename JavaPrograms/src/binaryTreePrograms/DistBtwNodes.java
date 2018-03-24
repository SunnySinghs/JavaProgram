package binaryTreePrograms;

public class DistBtwNodes {

	int d1 = -1;
	int d2 = -1;
	int dist = -1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dist = new DistBtwNodes().findDistance(new TreeNode().getTree(), 4, 6);
		System.out.println("\n\n>>>>>>>dist>>>>>>"+dist);
	}
	
	public TreeNode findDistUtil(TreeNode root, int n1, int n2, int lvl) {
		if(root==null) {
			return root;
		}
		if(root.data == n1) {
			d1 = lvl;
			return root;
		}
		if(root.data == n2) {
			d2 = lvl;
			return root;
		}
		
		TreeNode left = findDistUtil(root.left, n1, n2, lvl+1);
		TreeNode right = findDistUtil(root.right, n1, n2, lvl+1);
		
		if(left!=null && right!=null) {
			dist = (d1+d2) - 2*lvl;
			return root;
		}
		
		return (left!=null)?left:right;
	}
	
	int findDistance(TreeNode root, int n1, int n2) {
		d1 = -1;
		d2 = -1;
		dist = 0;
		TreeNode lca = findDistUtil(root, n1, n2, 1);
		
		if(d1!=-1 && d2!=-1) {
			return dist;
		}
		
		if(d1!=-1) {
			return new FindNodeLevel().findLevel(lca, n2, 0);
		}
		
		if(d2!=-1) {
			return new FindNodeLevel().findLevel(lca, n1, 0);
		}
		return -1;
	}

}
