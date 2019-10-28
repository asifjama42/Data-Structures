import java.lang.Math;
import java.util.LinkedList;
import java.util.Queue;

public class HeightBT {
	static int height = 0;
	//Recursive Approach
	public static int height(Node root) {
		if (root == null) {
			return -1;
		}
		height = Math.max(height(root.left) + 1, height(root.right) + 1);

		return height;
	}
	
	// Iterative Approach
	public static int heightBT(Node root) {
		height = 0;
		Queue<Node> queue = new LinkedList<>();
		if(root == null) return 0;
		queue.add(root);
		while(!queue.isEmpty()) {
			Node temp;
			int size = queue.size();
			while(size-->0) {
				temp = queue.poll();
				if(temp.left!=null) {
					queue.add(temp.left);
				}
				if(temp.right!=null) {
					queue.add(temp.right);
				}
			}
			height++;
		}
		
		
		
		
		return height;
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
		root.right.right.right.left = new Node(16); 
		root.right.right.right.left.right = new Node(17); 



		System.out.println("First Tree");
		PrintBTree.print2D(root);
		;
		System.out.println();
		System.out.print("Height of given Tree -> ");
		System.out.println(heightBT(root));
	}

}
/*
Output 
First Tree

                              15

                                                  17

                                        16

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

Height of given Tree -> 6
