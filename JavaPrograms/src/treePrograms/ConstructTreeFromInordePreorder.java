package treePrograms;

public class ConstructTreeFromInordePreorder {

	public static void main(String[] args) {
		ConstructTreeFromInordePreorder tree = new ConstructTreeFromInordePreorder();
		int in[] = new int[]{4, 2, 5, 1, 6, 3};
        int pre[] = new int[]{1, 2, 4, 5, 3, 6};
        int l = pre.length;
        TreeNode node = tree.buildTree(pre, in, 0, l-1);
        
        new TraversalProgramWithRecursion().inOrder(node);

	}
	
	TreeNode buildTree(int[] pre, int[] in,int start,int end){
		TreeNode node;
		int preIndex = 0;
		if(end < start){
			return null;
		}
		
		TreeNode tNode = new TreeNode(pre[preIndex++]);
		
		if(start == end){
			return tNode;
		}
		
		int index = search(in, start, end, tNode.data);
		
		tNode.left = buildTree(pre, in, start, index-1);
		tNode.right = buildTree(pre, in, index+1, end);
		return tNode;
	}

	private int search(int[] in, int start, int end, int data) {
		int index = 0;
		for(int i=start; i<=end; i++){
			if(in[i] == data){
				index = i;
			}
		}
		return index;
	}
	

}
