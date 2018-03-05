package binarySearchTreePrograms;

public class DeleteBST {
	Node root;
	public DeleteBST() {
		root = null;
	}
	public static void main(String[] args) {
		DeleteBST dbst = new DeleteBST();
		dbst.insertRec(50);
		dbst.insertRec(30);
		dbst.insertRec(20);
		dbst.insertRec(40);
		dbst.insertRec(70);
		dbst.insertRec(60);
		dbst.insertRec(80);
		
		System.out.println("Inorder traversal of the given tree");
		dbst.inorder();;
 
        /*System.out.println("\nDelete 20");
        dbst.DeleteRec(20);
        System.out.println("Inorder traversal of the modified tree");
        dbst.inorder();*/
 
        System.out.println("\nDelete 30");
        dbst.DeleteRec(30);
        System.out.println("Inorder traversal of the modified tree");
        dbst.inorder();
 
        /*System.out.println("\nDelete 50");
        dbst.DeleteRec(50);
        System.out.println("Inorder traversal of the modified tree");
        dbst.inorder();*/
	}

	void DeleteRec(int key) {
		root = DeleteInBST(root, key);
	}
	Node DeleteInBST(Node root, int key) {
		if(root==null)
			return root;
		System.out.println("\n>>root.data>>"+root.data);
		if(root.data < key) {
			System.out.println("\n>>root.right>>"+root.data);
			root.right = DeleteInBST(root.right, key);
		}else if(root.data > key) {
			System.out.println("\n>>root.left>>"+root.data);
			root.left = DeleteInBST(root.left, key);
		}else {

			System.out.println("\n>>11111>>"+root.data);
			if(root.left==null) {
				System.out.println("\n>>2222>>"+root.data);
				return root.right;
			}else if(root.right==null) {
				System.out.println("\n>>3333>>"+root.data);
				return root.left;
			}
			System.out.println("\n>>4444>>"+root.data);
			root.data = minValue(root.right, key);
			System.out.println("\n>>5555>>"+root.data);
			root.right = DeleteInBST(root.right, root.data);
			System.out.println("\n>>6666>>"+root.data);
		}
		return root;
	}

	int minValue(Node node, int key) {
		int data = node.data;
		while(node.left!=null) {
			data = node.left.data;
			node = node.left;
		}
		return data;
	}
	
	void insertRec(int key)
    {
        root = insertInBST(root, key);
    }
 
    Node insertInBST(Node root, int key)
    {
        if (root == null){
            root = new Node(key);
            return root;
        }
 
        if (key < root.data)
            root.left = insertInBST(root.left, key);
        else if (key > root.data)
            root.right = insertInBST(root.right, key);
 
        return root;
    }
    
    void inorder()
    {
        inorderRec(root);
    }
 
    void inorderRec(Node root)
    {
        if (root != null)
        {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }
}
