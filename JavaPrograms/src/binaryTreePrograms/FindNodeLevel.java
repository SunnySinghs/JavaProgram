package binaryTreePrograms;

public class FindNodeLevel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int l = new FindNodeLevel().findLevel(new TreeNode().getTree(), 5, 1);
		System.out.println("\n\n>>>>>llll>>>>>"+l);
	}
	
	int findLevel(TreeNode root, int k, int level) {
		if(root == null) {
			return -1;
		}
		if(root.data == k) {
			return level;
		}
		int l = findLevel(root.left, k, level+1);
		return (l!=-1)?l:findLevel(root.right, k, level+1);
	}

}
