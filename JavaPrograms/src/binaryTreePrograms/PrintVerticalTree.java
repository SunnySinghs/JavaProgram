package binaryTreePrograms;

public class PrintVerticalTree {

	TreeNode root;
	Values v = new Values();
	public static void main(String[] args) {
		new PrintVerticalTree().printOrder(new TreeNode().getTree());

	}
	void findMinMaxHorDist(TreeNode node, Values min, Values max, int hd) {
		if(node == null) {
			return;
		}
		if(hd < min.min)
			 min.min = hd;
		if(hd>max.max) {
			 max.max = hd;
		}
		
		findMinMaxHorDist(node.left, min, max, hd-1);
		findMinMaxHorDist(node.right, min, max, hd+1);
	}
	
	void printVerticalLine(TreeNode node, int lNo, int hd) {
		if(node == null) {
			return;
		}
		
		if(lNo == hd) {
			System.out.print(node.data+"");
		}
		
		printVerticalLine(node.left, lNo, hd-1);
		printVerticalLine(node.right, lNo, hd+1);
	}
	
	void printOrder(TreeNode node) {
		findMinMaxHorDist(node, v, v, 0);
		for(int i=v.min;i<=v.max;i++) {
			printVerticalLine(node, i, 0);
			System.out.println("");
		}
	}
	
	
}
