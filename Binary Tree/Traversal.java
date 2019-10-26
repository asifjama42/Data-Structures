
public class Traversal {
public static void inOrderTraversal(Node root) {
	if(root==null) return ;
	inOrderTraversal(root.left);
	System.out.print(root.data + "->");
	inOrderTraversal(root.right);
	
}

public static void preOrderTraversal(Node root) {
	if(root==null) return ;
	System.out.print(root.data+"->");
	preOrderTraversal(root.left);
	preOrderTraversal(root.right);
}

public static void postOrderTraversal(Node root) {
	if(root==null) return ;
	postOrderTraversal(root.left);
	postOrderTraversal(root.right);
	System.out.print(root.data+"->");
}

	public static void main(String[] args) {
		Node root = new Node(1); 
		root.left = new Node(2); 
		root.right = new Node(3); 

		root.left.left = new Node(4); 
		root.left.right = new Node(5); 
		root.right.left = new Node(6); 
		root.right.right = new Node(7); 

		root.left.left.left = new Node(8); 
		root.left.left.right = new Node(9); 
		root.left.right.left = new Node(10); 
		root.left.right.right = new Node(11); 
		root.right.left.left = new Node(12); 
		root.right.left.right = new Node(13); 
		root.right.right.left = new Node(14); 
		root.right.right.right = new Node(15); 
		System.out.println("First Tree");
		PrintBTree.print2D(root);
		System.out.print("In Order Traversal  "  );
		inOrderTraversal(root);
		System.out.println();
		System.out.print("Pre Order Traversal  "  );
		preOrderTraversal(root);
		System.out.println();
		System.out.print("Post Order Traversal  "  );
		postOrderTraversal(root);
	}

}
