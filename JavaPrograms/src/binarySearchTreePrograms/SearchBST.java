package binarySearchTreePrograms;

public class SearchBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SearchBST().searchKeyInBST(new Node().getTree(), 6);
	}

	void searchKeyInBST(Node root, int value) {
		if(root == null) {
			return;
		}
		if(root.data == value) {
			System.out.println("\n\n>>>>>>isFound>>>>true");
		}else if(root.right !=null && root.data<value) {
			searchKeyInBST(root.right, value);
		}else if(root.left !=null && root.data>value){
			searchKeyInBST(root.left, value);
		}else {
			System.out.println("\n\n>>>>>>isFound>>>>false");
		}
	}
}
