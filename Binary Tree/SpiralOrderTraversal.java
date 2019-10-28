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
		
		
		System.out.println();
		System.out.println("Spiral Order Traversal Using Hashing");
		levelOrderTraversal(root);
	}
		
	
	
	// Spiral Order Traversal using Hashing.

	
	public static void levelOrderTraversal(Node root) {
		Map<Integer,Deque<Integer>> map = new HashMap<>();
		preOrder(root,1,map);
		for(int i =1;i<=map.size();i++) {
			System.out.println(map.get(i).toString());
		}
		
	}
	
	
	public static void preOrder(Node root,int level,Map<Integer,Deque<Integer>> map) {
		
		if(root==null) return;
		
		if(!map.containsKey(level)) {
			map.put(level, new ArrayDeque<>());
		}
		if(level%2!=0) {
			map.get(level).addLast(root.data);
		}
		else {
			map.get(level).addFirst(root.data);
		}
		
		
		
		
		preOrder(root.left, level+1, map);
		preOrder(root.right,level+1,map);
		
		
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

Spiral Order Traversal..
1->3->2->4->5->6->7->15->14->13->12->11->10->9->8->
Spiral Order Traversal Using Hashing
[1]
[3, 2]
[4, 5, 6, 7]
[15, 14, 13, 12, 11, 10, 9, 8]
