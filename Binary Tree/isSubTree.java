import java.util.ArrayDeque;
import java.util.Deque;

public class subTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.left = new Node(4);
		root.right = new Node(5);

		root.left.left = new Node(1);
		root.left.right = new Node(2);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(0);

		System.out.println("First Tree");
		PrintBTree.print2D(root);
		System.out.println();

		Node root2 = new Node(4);
		root2.left = new Node(1);
		root2.right = new Node(2);
		System.out.println("Seceond Tree");
		PrintBTree.print2D(root2);
		System.out.println();
		if (isSubTree(root, root2)) {
			System.out.println("Yes it is sub Tree");
		} else {
			System.out.println("No it is not sub Tree");
		}

	}

	private static boolean isSubTree(Node root, Node root2) {
		if (root2 == null)
			return true;
		if (root == null)
			return false;

		return isSubTreeHelper(root, root2, false);
	}

	private static boolean isSubTreeHelper(Node root, Node root2, boolean b) {
		if (root == null && root2 == null)
			return true;
		if (root == null || root2 == null)
			return false;
		if (root.data == root2.data) {
			return isSubTreeHelper(root.left, root2.left, true) && isSubTreeHelper(root.right, root2.right, true)
					|| isSubTreeHelper(root.left, root2, false) || isSubTreeHelper(root.right, root2, false);

		}
		if (b) {
			return false;
		}
		return isSubTreeHelper(root.left, root2, b) || isSubTreeHelper(root.right, root2, false);
	}

}
/*
Output
First Tree

                              7

               5

                              6

1

                              2

               4

                              1

                                             0

Seceond Tree

               2

4

               1

No it is not sub Tree
