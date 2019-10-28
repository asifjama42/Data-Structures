public class Node { //A Linked List Node
	int data;
	Node nextNode;
	Node(int data,Node nextNode){
		this.data = data;
		this.nextNode = nextNode;
	}
	public Node() {
	}
	
	public Node(int data) {
		this.data = data;
	}
	
// @Override
// public void finalize() throws Throwable{
//	 System.out.println("Object destroying  " +this);
// }
	
	public static void main(String[] args) {
		
		
		Node e = new Node(5,null);
		Node d = new Node(4,e);
		Node c = new Node(3,d);
		Node b = new Node(2,c);
		Node head = new Node(1,b);
		LinkedList.printList(head);
		
		
		
	}
	
	
	
	
	
}
