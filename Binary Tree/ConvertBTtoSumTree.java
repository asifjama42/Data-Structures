
public class ConvertBTtoSumTree {
	public static int convert(Node root) {
		if (root == null)
			return 0;
		int l = convert(root.left);
		int r = convert(root.right);
		int old = root.data;
		root.data = l+r;
		return l+r + old;

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
		convert(root);
		System.out.println();
		System.out.println(" Sum Tree ");
		PrintBTree.print2D(root);
		
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


 Sum Tree 

                                             0

                              29

                                             0

               67

                                             0

                              25

                                             0

119

                                             0

                              21

                                             0

               47

                                             0

                              17

                                             0
