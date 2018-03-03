package binaryTreePrograms;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLevelOrderTraversalLineByLine {

	void PLOTLBL(TreeNode root) {
		if(root == null) {
			return;
		}
		
		TreeNode curr = root;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(curr);
		while(!q.isEmpty()) {
			TreeNode temp = q.poll();
			System.out.println(temp.data);
			if(temp.left!=null) {
				q.add(temp.left);
			}
			if(temp.right!=null) {
				q.add(temp.right);
			}
		}
	}
	
	void PLOTLBLR(TreeNode root) {
		int h = new HeightOfTree().heightOfTree(root);
		for(int i=1; i<=h; i++) {
			new TraversalProgramWithRecursion().printGivenLevel(root, i);
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PrintLevelOrderTraversalLineByLine().PLOTLBLR(new TreeNode().getTree());

	}

}
