import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;

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
					if (size == 0) {
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
		int value = 2;
		System.out.println("Next Node after " + value);
		Node dummy = (Node) nextNode(root, value);
		if (dummy != null)
			System.out.println("Next Node -> data " + dummy.data);
		else
			System.out.println("Null");

		System.out.println();
		System.out.println("Recursive Approach");
		Node dummy1 = (Node) findRightNode(root, value);
		if (dummy != null)
			System.out.println("Next Node -> data " + dummy1.data);
		else
			System.out.println("Null");
	}

	// using recursion
	public static Node findRightNode(Node root, int value) {
		AtomicInteger value_level = new AtomicInteger(0);
		Node node = findRightNode(root, value, 1, value_level);
		return node;
	}

	private static Node findRightNode(Node root, int value, int level, AtomicInteger value_level) {
		if(root==null) return null;
		System.out.println("Recursion "+root.data);

		if(root.data==value) {
			value_level.set(level);
			
		}
		else if(value_level.get()==level) {
			return root;
		}
		
		Node dummy = findRightNode(root.left, value, level+1, value_level);
		if(dummy!=null) return dummy;
		return findRightNode(root.right, value, level+1, value_level);
		
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
Next Node after 2
Next Node -> data 3

Recursive Approach
Recursion 1
Recursion 2
Recursion 4
Recursion 5
Recursion 3
Next Node -> data 3
