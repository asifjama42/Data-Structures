import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import javafx.util.Pair;
public class BottomView {
	static Map<Integer,Node> map = new HashMap<>();
	public static void bottomView(Node root) {
		 Deque<Pair<Node,Integer>> deque = new ArrayDeque<>();
		 deque.add(new Pair(root,0));
		 while(!deque.isEmpty()) {
			 Pair temp = deque.poll();
			 Node dummy = (Node)temp.getKey();
			 int hd = (Integer)temp.getValue();
			 if(dummy.left!=null) {
				 deque.add(new Pair(dummy.left,hd-1));
				 if(!map.containsKey(hd-1)) {
					 map.put(hd-1, dummy.left);
				 }
				 else 
					 map.put(hd-1, dummy.left);
				 
			 }
			 if(dummy.right!=null) {
				 deque.add(new Pair(dummy.right,hd+1));
				 if(!map.containsKey(hd+1)) {
					 map.put(hd+1, dummy.right);
					 
				 }
				 else
					 map.put(hd+1, dummy.right);
			 }
		 }
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
		System.out.println();
		bottomView(root);
		for(Map.Entry entry : map.entrySet()) {
			System.out.println("Horizotal Distance : " +  entry.getKey() + " " + " Value " + ((Node)entry.getValue()).data);
		}
		System.out.println();
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

Horizotal Distance : -1  Value 7
Horizotal Distance : 0  Value 5
Horizotal Distance : 1  Value 8
Horizotal Distance : 2  Value 6

