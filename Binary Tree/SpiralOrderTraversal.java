import java.util.ArrayDeque;
import java.util.Deque;

public class SpiralOrderTraversal {
	static int level = 1;

	public static void traverse(Node root) {
		if (root == null)
			return;

		Deque<Node> deque = new ArrayDeque();
		deque.add(root);
		while (!deque.isEmpty()) {
			int size = deque.size();
			while (size-- > 0) {
				Node temp = deque.pollFirst();
				System.out.print(temp.data + "->");
				if (temp.left != null) {
					deque.add(temp.left);
				}
				if (temp.right != null) {
					deque.add(temp.right);
				}

			}

			size = deque.size();
			while (size-- > 0 && !deque.isEmpty()) {
				Node temp = deque.pollLast();
				System.out.print(temp.data + "->");
				if(temp.right!=null) {
					deque.addFirst(temp.right);
				}
				if(temp.left!=null) {
					deque.addFirst(temp.left);
				}
				
			}

		}

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
		System.out.println("Spiral Order Traversal..");
		traverse(root);
	}

}
