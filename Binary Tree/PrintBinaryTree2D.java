class PrintBTree 
{ 
	
static final int COUNT = 10; 



// reverse inorder traversal 
public static void print2DUtil(Node root, int space) 
{ 
	if (root == null) 
		return; 

	space += COUNT; 

	print2DUtil(root.right, space); 

	System.out.print("\n"); 
	for (int i = COUNT; i < space; i++) 
		System.out.print(" "); 
	System.out.print(root.data + "\n"); 

	print2DUtil(root.left, space); 
} 

static void print2D(Node root) 
{ 
	print2DUtil(root, 0); 
} 

public static void main(String args[]) 
{ 
	Node root = new Node(15);
		root.left = new Node(10);
		root.right = new Node(20);

		root.left.left = new Node(8);
		root.left.right = new Node(12);
		root.right.left = new Node(16);
		root.right.right = new Node(25);
		root.right.right.left = new Node(23);
	
	print2D(root); 
} 
} 


