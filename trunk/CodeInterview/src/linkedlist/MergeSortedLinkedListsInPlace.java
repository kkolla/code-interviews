package linkedlist;

import utils.CreateUtils;
import utils.PrintUtils;

public class MergeSortedLinkedListsInPlace {

	// a more efficient way is to use heap
	// which reduces the complexity from O(m*n) to O(m*log(n))
	public static Node mergeSortedLinkedLists(Node[] heads) {
		Node head = null;
		Node iter = null;
		while (true) {
			// keep doing the logic until all heads are null
			boolean allHeadsNull = true;
			for (Node h : heads)
				if (h != null)
					allHeadsNull = false;
			if (allHeadsNull)
				break;

			Node smallest = null;
			int smallestHeadIndex = -1;
			for (int i = 0; i < heads.length; i++) {
				Node h = heads[i];
				if (h == null)
					continue;
				if (smallest == null || h.value < smallest.value) {
					smallest = h;
					smallestHeadIndex = i;
				}
			}
			// move the smallest head ahead
			heads[smallestHeadIndex] = heads[smallestHeadIndex].next;
			// first time
			if (head == null)
				head = smallest;
			// after first time
			if (iter != null)
				iter.next = smallest;
			iter = smallest;
			iter.next = null;
		}
		return head;
	}

	public static void main(String[] args) {
		Node[] heads = new Node[] {
				CreateUtils.createSortedLinkedListFromOneToN(6),
				CreateUtils.createSortedLinkedListFromOneToN(8),
				CreateUtils.createSortedLinkedListFromOneToN(5),
				CreateUtils.createSortedLinkedListFromOneToN(7),
				CreateUtils.createSortedLinkedListFromOneToN(20) };
		Node head = mergeSortedLinkedLists(heads);
		PrintUtils.printLinkedList(head);
	}

}
