package binarySearchTreePrograms;

public class LowestCommonAncester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("\n\n>>>>>>>>>>>"+new LowestCommonAncester().LCA(new Node().getTree(), 3, 6).data);

	}
	
	Node LCA(Node root, int n1, int n2) {
		if(root == null) {
			return root;
		}
		if(root.data > n1 && root.data > n2) {
			return LCA(root.left, n1, n2);
		}
		
		if(root.data < n1 && root.data < n2) {
			return LCA(root.right, n1, n2);
		}
		
		return root;
	}

}
