
public class MergeSortAlgorithm {
	static Node dummyNode = new Node();
	static Node result = dummyNode;

	public static Node mergeSort(Node head) {
		dummyNode.nextNode = head;
		if (head.nextNode == null) {
			return head;
		}
		Node[] split = SplitLL.FrontBackSplit(head);
		Node frontRef = split[0];
		Node backRef = split[1];
		System.out.print("Front Ref ");
		LinkedList.printList(frontRef);
		System.out.print("Back Ref ");
		LinkedList.printList(backRef);
		frontRef = mergeSort(frontRef);
		backRef = mergeSort(backRef);

		result = MergeSortedList.sortedMerge(frontRef, backRef);
		System.out.println("From Merge Sorted List");
		LinkedList.printList(result);

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 9,8,7,6,5,4,3,2};
		Node head = null;
		for (int i = a.length - 1; i >= 0; i--) {
			head = new Node(a[i], head);
		}
		LinkedList.printList(head);
		head = mergeSort(head);
		System.out.println(" \nResult is -> ");
		LinkedList.printList(head);

	}

}
/*
Output
Linked List...9->8->7->6->5->4->3->2->null
Front Ref Linked List...9->8->7->6->null
Back Ref Linked List...5->4->3->2->null
Front Ref Linked List...9->8->null
Back Ref Linked List...7->6->null
Front Ref Linked List...9->null
Back Ref Linked List...8->null
From Merge Sorted List
Linked List...8->9->null
Front Ref Linked List...7->null
Back Ref Linked List...6->null
From Merge Sorted List
Linked List...6->7->null
From Merge Sorted List
Linked List...6->7->8->9->null
Front Ref Linked List...5->4->null
Back Ref Linked List...3->2->null
Front Ref Linked List...5->null
Back Ref Linked List...4->null
From Merge Sorted List
Linked List...4->5->null
Front Ref Linked List...3->null
Back Ref Linked List...2->null
From Merge Sorted List
Linked List...2->3->null
From Merge Sorted List
Linked List...2->3->4->5->null
From Merge Sorted List
Linked List...2->3->4->5->6->7->8->9->null
 
Result is -> 
Linked List...2->3->4->5->6->7->8->9->null
