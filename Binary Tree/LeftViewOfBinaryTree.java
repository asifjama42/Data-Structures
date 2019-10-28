import java.util.HashMap;
import java.util.Map;

public class LeftViewBinaryTree {
	public static void leftView(Node root) {
		Map<Integer,Node> map = new HashMap<>();
		preOrder(root,1,map);
		for(int i = 1;i<=map.size();i++) {
			System.out.print(map.get(i).data + "-");
		}
	}
	private static void preOrder(Node root, int level, Map<Integer, Node> map) {
		if(root==null)return;
		if(!map.containsKey(level)) {
			map.put(level, root);
		}
		preOrder(root.left, level+1, map);
		preOrder(root.right, level+1, map);
	}
	//Iterative Approach
	
	static int size = 0;
	public static void leftViewIttreative(Node root) {
		Deque<Node> deque = new ArrayDeque<>();
		if(root!=null)deque.add(root);
		
		while(!deque.isEmpty()) {
			int i =0;
			size = deque.size();
			while(i++<size) {
				if (i==1) {
					System.out.print(deque.peekFirst().data +"-");
				}
				Node temp = deque.poll();
				if(temp.left!=null) {
					deque.add(temp.left);
					
				}
				if(temp.right!=null) {
					deque.add(temp.right);
					
				}
					
			}
			
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		//root.left.left = new Node(4);
		//root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		//root.left.left.left = new Node(8);
		//root.left.left.right = new Node(9);
		//root.left.right.left = new Node(10);
		//root.left.right.right = new Node(11);
		//root.right.left.left = new Node(12);
		//root.right.left.right = new Node(13);
		//root.right.right.left = new Node(14);
		root.right.right.right = new Node(15);

		System.out.println("First Tree");
		PrintBTree.print2D(root);
		System.out.println();
		leftView(root);
	}

}
/*
Output

First Tree

                              15

                    7

          3

                    6

1

          2

1-2-6-15-
*/
