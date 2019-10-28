import java.util.ArrayDeque;
import java.util.Deque;

public class PrintSpecificOrder {

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
		traverse(root);
		System.out.println();
		System.out.println("RDeque Size " + rdeque.size());
		int s = rdeque.size();
		for (int i = 1; i <= s; i++) {
			System.out.print(rdeque.pollFirst().data + "-");
		}
				
		traverseInSpecificOrder(root);

	}

	static Deque<Node> deque = new ArrayDeque<>();
	static Deque<Node> rdeque = new ArrayDeque<>();
	static Deque<Node> tdeque;

	private static void traverse(Node root) {
		if (root == null)
			return;
		deque.add(root);
		boolean flag = true;
		int size = deque.size();
		rdeque.add(root);
		while (!deque.isEmpty()) {

			size = deque.size();

			while (size-- > 0) {
				Node temp = deque.poll();
				if (temp.left != null) {
					deque.add(temp.left);
				}
				if (temp.right != null) {
					deque.add(temp.right);

				}
			}
			tdeque = new ArrayDeque<>(deque);
			size = tdeque.size();
			while (size-- > 0 && !deque.isEmpty()) {
				if (flag) {

					rdeque.add(tdeque.pollFirst());

					flag = false;
				} else {

					rdeque.add(tdeque.pollLast());

					flag = true;
				}
			}

		}
	}
	
	public static void traverseInSpecificOrder(Node root) {
		if (root == null)
			return;
		Deque<Node> dequeL = new ArrayDeque<>(), dequeR = new ArrayDeque<>();
		dequeL.add(root.left);
		dequeR.add(root.right);
		System.out.print(root.data+"->");
		while (!dequeL.isEmpty()) {
			int size = dequeL.size();
			while (size-- > 0) {
				Node temp = dequeL.poll();
				if (temp.left != null) {
					dequeL.add(temp.left);
				}
				if (temp.right != null) {
					dequeL.add(temp.right);

				}
				System.out.print(temp.data + "->");

				temp = dequeR.poll();
				if (temp.left != null) {
					dequeR.add(temp.right);
				}
				if (temp.right != null) {
					dequeR.add(temp.left);

				}
				System.out.print(temp.data+"->");
			}
		}

	}

}
