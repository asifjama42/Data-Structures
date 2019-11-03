import java.util.LinkedList;
import java.util.Queue;

public class PrintCousins {
	static int depth = -1;
	static Node parent = null;
	static Queue<Integer> queue = new LinkedList<>();

	public static void findCousins(Node root, int val) {
		depthAndParent(root, val, 0, null);
		//System.out.println(depth + " " + parent.data);
		getCousins(root, 0, null);
		while (!queue.isEmpty()) {
			System.out.print(queue.poll() + "-");
		}
	}

	private static void getCousins(Node root, int dep, Node par) {
		if (root == null)
			return;
		if (depth == dep && par != parent) {
			queue.add(root.data);

		}
		getCousins(root.left, dep + 1, root);
		getCousins(root.right, dep + 1, root);

	}

	private static void depthAndParent(Node root, int val, int d, Node par) {
		if (root == null)
			return;
		if (root.data == val) {
			depth = d;
			parent = par;

		}
		depthAndParent(root.left, val, d + 1, root);
		depthAndParent(root.right, val, d + 1, root);

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
		System.out.println();
		System.out.println("Cousins are ");
		findCousins(root, 9);

	}

}
/*
Output
First Tree

                                             15

                              7

                                             14

               3

                                             13

                              6

                                             12

1

                                             11

                              5

                                             10

               2

                                             9

                              4

                                             8

Cousins are 
10-11-12-13-14-15-
