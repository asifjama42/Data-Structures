import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1); 
		root.left = new Node(2); 
		root.right = new Node(3); 

		root.left.left = new Node(4); 
		root.left.right = new Node(5); 
		root.right.left = new Node(6); 
		root.right.right = new Node(7); 

		root.left.left.left = new Node(8); 
		root.left.left.right = new Node(9); 
		//root.left.right.left = new Node(10); 
		root.left.right.right = new Node(11); 
		root.right.left.left = new Node(12); 
		root.right.left.right = new Node(13); 
		//root.right.right.left = new Node(14); 
		root.right.right.right = new Node(15); 

		System.out.println("First Tree");
		PrintBTree.print2D(root);
		System.out.println();
		System.out.println("Reverse Level Order Traversal..");
		traverse(root);
		System.out.println(rdeque.size());
		System.out.print(rdeque);
		
	}
	static Deque<Node> deque = new ArrayDeque<>();
	static Deque<Integer> rdeque = new ArrayDeque<>();
	private static void traverse(Node root) {
		if(root == null) return;
		deque.add(root);
		while(!deque.isEmpty()) {
			Node temp = deque.poll();
			rdeque.addFirst(temp.data);
		if(temp.left!=null) {
			deque.add(temp.left);
		}
		if(temp.right!=null) {
			deque.add(temp.right);
		}
		
	}
	
	}
}
/*
Output
First Tree

                              15

                    7

          3

                              13

                    6

                              12

1

                              11

                    5

          2

                              9

                    4

                              8

Reverse Level Order Traversal..
13
[15, 13, 12, 11, 9, 8, 7, 6, 5, 4, 3, 2, 1]

*/
