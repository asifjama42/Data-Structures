
public class EqualBT {

	private static boolean isIdentical(Node x, Node y) {

		if (x == null && y == null) {
			return true;
		}
		System.out.println("treversing x -> " +x.data + " y-> "  + y.data);
		return (x != null && y != null) && (x.data == y.data) && isIdentical(x.left, y.left)
				&& isIdentical(x.right, y.right);

	}

	private static Node insert(Node root, int data) {
		if (root == null) {
			Node node = new Node(data);
			return node;
		} else if (root.data > data) {
			root.left = insert(root.left, data);
		} else if (root.data < data) {
			root.right = insert(root.right, data);
		}
		return root;
	}

	private static void printBTree(Node root) {
		if (root == null)
			return;
		else {
			printBTree(root.left);
			System.out.print(root.data + "->");
			printBTree(root.right);
		}
	}
	
	

	public static void main(String[] args) {
		Node node = new Node(15);
		node.left = new Node(10);
		node.right = new Node(20);
		node.left.left = new Node(8);
		node.left.right = new Node(12);
		node.right.left = new Node(16);
		node.right.right = new Node(25);
		System.out.println("1st binary Tree");
		printBTree(node);
		System.out.println();
		System.out.println("2nd binary Tree");

		Node root = new Node(15);
		insert(root, 10);
		insert(root, 20);
		insert(root, 8);
		insert(root, 12);
		insert(root, 16);
		insert(root, 25);
		printBTree(root);
		System.out.println();
		if(isIdentical(node, root))
	    System.out.println("The Given Trees are Identical..");
		else
		System.out.println("The Given Trees are not Identical..");

		
		
	}
	

}

