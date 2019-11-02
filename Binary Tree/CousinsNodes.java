import java.util.ArrayDeque;
import java.util.Queue;

public class CousinNodeBT {

	public static boolean isCousins(Node root, int a, int b) {
		Queue<Pair<Node, Integer>> queue = new ArrayDeque<>();
		int parent1 = -1;
		int parent2 = -1;
		if (root.left != null)
			queue.add(new Pair<Node, Integer>(root.left, root.data));
		if (root.right != null)
			queue.add(new Pair<Node, Integer>(root.right, root.data));
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				Pair temp = queue.poll();
				Node dummy = (Node) temp.first;
				int parent = (Integer) temp.second;
				if (dummy.left != null)
					queue.add(new Pair<Node, Integer>(dummy.left, dummy.data));
				if (dummy.right != null)
					queue.add(new Pair<Node, Integer>(dummy.right, dummy.data));
				if (a == dummy.data) {
					parent1 = parent;

				}

				if (b == dummy.data) {
					parent2 = parent;
				}
				if (size == 0) {
					System.out.println(parent1 + " " + parent2);
					if (parent1 != -1 && parent2 == -1)
						return false;
					if (parent1 == -1 && parent2 != -1)
						return false;
					if (parent1 != -1 && parent2 != -1 && parent1 != parent2)
						return true;
				}

			}
		}
		return false;

	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.right = new Node(4);
		root.right.right = new Node(5);

		System.out.println("First Tree");
		PrintBTree.print2D(root);
		System.out.println();

		System.out.println(isCousins(root, 5, 4));
	}

}
/*
Output
First Tree

                              5

               3

1

                              4

               2

-1 -1
3 2
true
