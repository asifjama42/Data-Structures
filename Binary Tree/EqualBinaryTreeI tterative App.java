import java.util.ArrayDeque;
import java.util.Deque;

class Pair<U, V> {
	public final U first;
	public final V second;

	public Pair(U first, V second) {
		this.first = first;
		this.second = second;
	}

	public static <U, V> Pair<U, V> of(U a, V b) {
		return new Pair<>(a, b);
	}
}

public class EqualBTItrativeApp {

	public static boolean Isequal(Node x, Node y) {

		if (x == null && y == null) {
			return true;

		}
		if (x == null) {
			return false;
		}
		if (y == null) {
			return false;
		}
		Deque<Pair<Node, Node>> stack = new ArrayDeque<>();
		stack.add(Pair.of(x, y));
		Node a, b;
		while (!stack.isEmpty()) {
			a = stack.peek().first;
			b = stack.peek().second;
			System.out.print(a.data + "->");
			System.out.println(b.data + "->");
			stack.poll();

			if (a.data != b.data) {
				return false;
			}
			if (a.left != null && b.left != null) {
				stack.add(Pair.of(a.left, b.left));
			} else if (a.left != null && b.left == null || a.left == null && b.left != null) {
				return false;
			}
			if (a.right != null && b.right != null) {
				stack.add(Pair.of(a.right, b.right));

			} else if (a.right != null && b.right == null || a.right == null && b.right != null) {
				return false;
			}

		}

		return true;
	}

	public static void main(String[] args) {

		Node node = new Node(15);
		node.left = new Node(10);
		node.right = new Node(20);
		// node.left.right = new Node(12);
		// node.right.right = new Node(25);
		System.out.println("First Tree");
		EqualBT.printBTree(node);
		System.out.println();

		Node root = new Node(15);
		EqualBT.insert(root, 10);
		// EqualBT.insert(root, 20);
		// EqualBT.insert(root, 12);
		// EqualBT.insert(root, 16);
		// EqualBT.insert(root, 25);
		System.out.println("Second tree");
		EqualBT.printBTree(root);
		System.out.println();
		if (Isequal(node, root))
			System.out.print("The Given Trees are Identical");
		else
			System.out.print("The Given Trees are not Identical");

	}
}
