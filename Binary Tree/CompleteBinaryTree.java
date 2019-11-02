import java.util.ArrayDeque;
import java.util.Queue;

public class CompleteBinaryTree {

	public static boolean isCompleteBT(Node root) {
		boolean flag = true;
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				Node temp = queue.poll();
				if(temp.left!=null&&temp.right!=null) {
					if(flag) {
					queue.add(temp.left);
					queue.add(temp.right);
					}
					else return false;
				}
				else if(temp.left==null&&temp.right==null) flag = false;
				if(temp.left!=null&&temp.right==null) {
					if(flag)queue.add(temp.left);
					else return false;
					flag = false;
				}
				
				if(temp.left==null&&temp.right!=null) return false;
				
				
			}
		}
		
		
		
		
		
		
		return true;

	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		//root.right.left = new Node(6);
//		root.right.left.left = new Node(7);
//		root.right.left.right = new Node(8);

		System.out.println("First Tree");
		PrintBTree.print2D(root);
		System.out.println();
		System.out.println(isCompleteBT(root));
	}

}

/*
Output
First Tree

               3

1

                              5

               2

                              4

true
