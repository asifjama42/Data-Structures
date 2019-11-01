import java.util.ArrayDeque;
import java.util.Deque;

public class NextNodeInBinaryTree {
	public static Node nextNode(Node root, int value) {
		Deque<Node> deque = new ArrayDeque<>();
		deque.add(root);
		int level = 0;
		while (!deque.isEmpty()) {
			level++;
			int size = deque.size();
			while (size-- > 0) {
				Node dummy = deque.poll();
				if (dummy.data == value) {
					if (size==0) {
						return null;
					} else
						return deque.peek();
				}
				if (dummy.left != null) {
					deque.add(dummy.left);
				}
				if (dummy.right != null) {
					deque.add(dummy.right);
				}
			}

		}

		return null;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.left.left = new Node(7);
		root.right.left.right = new Node(8);

		System.out.println("First Tree");
		PrintBTree.print2D(root);
		int value = 1;
		System.out.println("Next Node after " + value);
		Node dummy = (Node) nextNode(root, value);
		if(dummy!=null)
		System.out.println("Next Node -> data " + dummy.data);
		else
			System.out.println("Null");

	}

}
/*
Output
First Tree

          3

                              8

                    6

                              7

1

                    5

          2

                    4
Next Node after 7
Next Node -> data 8
