import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TopViewBinaryTree {
	static Map<Integer, Node> map = new HashMap<>();
	static Map<Integer, Pair<Integer, Node>> lmap = new TreeMap<>();

	public static void topView(Node root) {
		Deque<Pair<Integer, Node>> deque = new ArrayDeque<>();
		map.put(0, root);
		deque.add(new Pair(0, root));
		while (!deque.isEmpty()) {
			Pair temp = deque.poll();
			Node dummy = (Node) temp.second;
			int hd = (Integer) temp.first;
			if (!map.containsKey(hd)) {
				map.put(hd, dummy);
			}
			if (dummy.left != null) {
				deque.add(new Pair(hd - 1, dummy.left));
			}
			if (dummy.right != null) {
				deque.add(new Pair(hd + 1, dummy.right));
			}
		}
	}

	public static void recursive(Node root, int level, int hd, Map<Integer, Pair<Integer, Node>> lmap) {
		if (root == null)
			return;
		if (!lmap.containsKey(hd) || level < lmap.get(hd).first) {
			lmap.put(hd, new Pair(level, root));

		}
		recursive(root.left, level + 1, hd - 1, lmap);
		recursive(root.right, level + 1, hd + 1, lmap);

	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.left = new Node(7);
		root.right.left.right = new Node(8);

		System.out.println("First Tree");
		PrintBTree.print2D(root);
		System.out.println("Top View ");
		recursive(root, 0, 0, lmap);
//		for (Map.Entry entry : lmap.entrySet()) {
//			System.out.println(
//					"HD-> " + (Integer) entry.getKey() + " Value -> " + ((Node) ((Pair) entry.getValue()).second).data);
//		}

		for (Pair<Integer, Node> pair : lmap.values()) {
			System.out.println(((Node) pair.second).data);
		}
	}

}
/*
Output
First Tree

                    6

          3

                              8

                    5

                              7

1

                    4

          2
Top View 
2
1
3
6
