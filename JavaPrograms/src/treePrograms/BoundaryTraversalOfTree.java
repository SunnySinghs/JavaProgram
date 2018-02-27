package treePrograms;

public class BoundaryTraversalOfTree {
	void printLeaves(TreeNode node) {
		if(node!=null) {
			printLeaves(node.left);
			if(node.left==null && node.right==null) {
				System.out.println(node.data+" ");
			}
			printLeaves(node.right);
		}
	}
	
	void printLeftBoundary(TreeNode node) {
		if(node!=null) {
			//System.out.println("node data "+node.data);
			if(node.left!=null) {
				//System.out.println("111");
				//System.out.println(node.data+" ");
				printLeftBoundary(node.left);
			}else if(node.right!=null) {
				//System.out.println("222");
				System.out.println(node.data+" ");
				printLeftBoundary(node.right);
			}
		}
	}
	
	void printRightBoundary(TreeNode node) {
		if(node!=null) {
			if(node.right!=null) {
				printLeftBoundary(node.right);
				System.out.println(node.data+" ");
			}else if(node.left!=null) {
				printLeftBoundary(node.left);
				System.out.println(node.data+" ");
			}
		}
	}
	
	void printBoundary(TreeNode node) {
		if(node!=null) {
			System.out.println(node.data);
			printLeftBoundary(node.left);
			printLeaves(node.left);
			printLeaves(node.right);
			printRightBoundary(node.right);
		}
	}
	public static void main(String[] args) {
		new BoundaryTraversalOfTree().printBoundary(new TreeNode().getTree());
	}
}
