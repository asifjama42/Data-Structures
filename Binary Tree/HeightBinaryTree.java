import java.lang.Math;;

public class HeightBT {
	static int height = 0;

	public static int height(Node root) {
		if (root == null) {
			return -1;
		}
		height = Math.max(height(root.left) + 1, height(root.right) + 1);

		return height;
	}

	public static void main(String[] args) {
		Node root = new Node(15);
		root.left = new Node(10);
		root.right = new Node(20);

		root.left.left = new Node(8);
		root.left.right = new Node(12);
		root.right.left = new Node(16);
		root.right.right = new Node(25);
		root.right.right.left = new Node(23);

		// root.left.left.left = new Node(8);
		// root.left.left.right = new Node(9);
		// root.left.right.left = new Node(10);
		// root.left.right.right = new Node(11);
		// root.right.left.left = new Node(12);
		// root.right.left.right = new Node(13);
		// root.right.right.left = new Node(14);
		// root.right.right.right = new Node(15);

		System.out.println("First Tree");
		PrintBTree.print2D(root);
		;
		System.out.println();
		System.out.print("Height of given Tree -> ");
		System.out.println(height(root));
	}

}
