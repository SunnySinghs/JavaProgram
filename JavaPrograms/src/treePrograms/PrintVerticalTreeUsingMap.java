package treePrograms;

import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Vector;

public class PrintVerticalTreeUsingMap {

	public static void main(String[] args) {
		new PrintVerticalTreeUsingMap().printOrder(new TreeNode().getTree());

	}
	
	void printVerticalOrder(TreeNode node, int hd, TreeMap<Integer,Vector<Integer>> map) {
		if(node == null) {
			return;
		}
		
		Vector<Integer> v = map.get(hd);
		if(v == null) {
			v = new Vector<Integer>();
			v.add(node.data);
		}else {
			v.add(node.data);
		}
		
		map.put(hd, v);
		printVerticalOrder(node.left, hd-1, map);
		printVerticalOrder(node.right, hd+1, map);
	}
	
	void printOrder(TreeNode node) {
		TreeMap<Integer,Vector<Integer>> map = new TreeMap<Integer,Vector<Integer>>();
		printVerticalOrder(node, 0, map);
		for(Entry<Integer, Vector<Integer>> entry : map.entrySet()) {
			System.out.println(entry.getValue()+" ");
		}
	}

}
