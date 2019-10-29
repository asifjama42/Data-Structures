import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import javafx.util.Pair;
public class VerticalLevelTraversal {
	static int hd = 0;
	static 		Map<Integer,Deque<Integer>> map = new HashMap<>();
//Not done
	public static void traverseVertically(Node root) {
		if(root == null) return;
		Deque<Pair<Node,Integer>> deque = new ArrayDeque<>();
		deque.add(new Pair(root,0));
		map.put(0, new ArrayDeque<>());
		map.get(0).add(root.data);
		while(!deque.isEmpty()) {
			Pair temp = deque.poll();
			Node dummy = (Node)temp.getKey();
			hd = (Integer)temp.getValue();
			if(dummy.left!=null) {
				deque.add( new Pair(dummy.left,hd-1));
				if(!map.containsKey(hd-1)) {
					map.put(hd-1, new ArrayDeque<>());
					map.get(hd-1).add(dummy.left.data);
				}
				else
				map.get(hd-1).add(dummy.left.data);
			}
			if(dummy.right!=null) {
				deque.add(new Pair(dummy.right,hd+1));
				if(!map.containsKey(hd+1)) {
					map.put(hd+1, new ArrayDeque<>());
					map.get(hd+1).add(dummy.right.data);
				}
				else
				map.get(hd+1).add(dummy.right.data);
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
		traverseVertically(root);
		for(Map.Entry entry : map.entrySet()) {
			System.out.println("Horizotal Distance : " +  entry.getKey() + " " + " Value " + entry.getValue());
		}
		System.out.println();
		System.out.println("Recursive Try");
		traverse(root, 0);
		for(Map.Entry entry : mapI.entrySet()) {
			System.out.println("Horizotal Distance : " +  entry.getKey() + " " + " Value " + entry.getValue() );
			}
	}
	static Map<Integer,Deque<Integer>> mapI = new HashMap<>(); 
	public static void traverse(Node root,int hd) {
		if(root == null) return;
		if(!mapI.containsKey(hd)) {
			mapI.put(hd, new ArrayDeque<>());
			mapI.get(hd).add(root.data);
			
		}
		else mapI.get(hd).add(root.data);
		
		traverse(root.left, hd-1);
		traverse(root.right, hd+1);
		
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

Horizotal Distance : 0  Value [1, 5, 6]
Horizotal Distance : -1  Value [2, 9, 10, 12]
Horizotal Distance : 1  Value [3, 11, 13, 14]
Horizotal Distance : -2  Value [4]
Horizotal Distance : 2  Value [7]
Horizotal Distance : -3  Value [8]
Horizotal Distance : 3  Value [15]

Recursive Try
Horizotal Distance : 0  Value [1, 5, 6]
Horizotal Distance : -1  Value [2, 9, 10, 12]
Horizotal Distance : -2  Value [4]
Horizotal Distance : 1  Value [11, 3, 13, 14]
Horizotal Distance : -3  Value [8]
Horizotal Distance : 2  Value [7]
Horizotal Distance : 3  Value [15]
