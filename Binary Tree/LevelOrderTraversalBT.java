import java.util.LinkedList;
import java.util.Queue;
public class LevelOrderTraversal {

	public static void levelOrderTraversal(Node root) {
	Queue<Node> queue = new LinkedList<>();
	if(root==null) {
		return;
	}
	queue.add(root);
	while(!queue.isEmpty()) {
		Node temp = queue.poll();
		System.out.print(temp.data + "->");
		if(temp.left!=null) {
			queue.add(temp.left);
			
		}
		if(temp.right!=null) {
			queue.add(temp.right);
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
		System.out.println("Level Order Traversal.");
		levelOrderTraversal(root);
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

Level Order Traversal.
1->2->3->4->5->6->7->8->9->10->11->12->13->14->15->
