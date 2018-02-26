package treePrograms;

public class PrintLeftView {
	static int max_level = Integer.MIN_VALUE;
	public void printLeftView(TreeNode root, int level) {
		//System.out.println("\n\n>>>>>Start Level>>>>>>>>"+level);
		if(root == null) {
			return;
		}
		//System.out.println("\n\n>>>1111>>>>>"+max_level);
		if(max_level<level) {
			System.out.println(root.data+" ");
			//System.out.println("\n\n>>>2222>>>>>"+max_level);
			max_level = level;
			//System.out.println("\n\n>>>3333>>>>>"+max_level);
		}else {
			//System.out.println("\n\n>>>4444>>>>>"+max_level);
			//max_level = max_level - 1;
			//System.out.println("\n\n>>>5555>>>>>"+max_level);
		}
		//System.out.println("\n\n>>>Left Level>>>"+level);
		//System.out.println("\n\n>>>Left Level data>>>"+root.left.data);
		printLeftView(root.left, level+1);
		//System.out.println("\n\n>>>Right Level>>>"+level);
		//System.out.println("\n\n>>>Left Level data>>>"+root.right.data);
		printLeftView(root.right, level+1);
		
	}
	public static void main(String[] args) {
		TreeNode tn = new TreeNode().getTree();
		PrintLeftView plv = new PrintLeftView();
		plv.printLeftView(tn, 1);
	}

}
