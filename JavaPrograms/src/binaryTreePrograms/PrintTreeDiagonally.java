package binaryTreePrograms;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

public class PrintTreeDiagonally {

	public void printDiagonally(TreeNode root, int d, Map<Integer, Vector<Integer>> diagonalPrint) {
		if(root == null) {
			return;
		}
		
		Vector v = diagonalPrint.get(d);
		if(v==null) {
			v = new Vector<Integer>();
			v.add(root.data);
		}else {
			v.add(root.data);
		}
		diagonalPrint.put(d,v);
		printDiagonally(root.left, d+1, diagonalPrint);
		printDiagonally(root.right, d, diagonalPrint);
	}
	public static void main(String[] args) {
		Map<Integer, Vector<Integer>> diagonalPrint = new HashMap<Integer, Vector<Integer>>();
		new PrintTreeDiagonally().printDiagonally(new TreeNode().getTree(), 0, diagonalPrint);
		for(Entry<Integer, Vector<Integer>> entry : diagonalPrint.entrySet()) {
			System.out.println(entry.getValue());
		}

	}

}
