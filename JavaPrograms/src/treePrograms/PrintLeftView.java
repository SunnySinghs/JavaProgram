package treePrograms;

public class PrintLeftView {
	static int max_level = Integer.MIN_VALUE;
	public void printLeftView(TreeNode root, int level) {
		if(root == null) {
			return;
		}
		
		if(max_level<level) {
			System.out.println(root.data+" ");
			max_level = level;
		}else {
			max_level = max_level - 1;
		}
		
		printLeftView(root.left, level+1);
		printLeftView(root.right, level+1);
		
	}
	public static void main(String[] args) {
		TreeNode tn = new TreeNode().getTree();
		PrintLeftView plv = new PrintLeftView();
		plv.printLeftView(tn, 1);
	}

}
