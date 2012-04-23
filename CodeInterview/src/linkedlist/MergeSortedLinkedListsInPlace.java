package linkedlist;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import utils.CreateUtils;
import utils.PrintUtils;
import datastructure.Pair;

public class MergeSortedLinkedListsInPlace {

	// O(kn)
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

	// O(nlog(k))
	public static Node mergeSortedLinkedListsBoosted(List<Node> heads) {
		if (heads == null || heads.size() == 0) {
			return null;
		}
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		Node head = null, curr = null;
		int finished = 0;
		for (int i = 0; i < heads.size(); i++) {
			if (heads.get(i) != null)
				q.add(heads.get(i));
			else
				finished++;
		}
		while (finished < heads.size()) {
			Node n = q.poll();
			if (head == null) {
				head = n;
				curr = head;
			} else {
				curr.next = n;
				curr = curr.next;
			}
			if (n.next == null) {
				finished++;
			} else {
				q.add(n.next);
			}
		}
		return head;
	}

	public static void main(String[] args) {
		Node[] heads = new Node[] { CreateUtils.sortedLinkedListFromOneToN(6),
				CreateUtils.sortedLinkedListFromOneToN(8),
				CreateUtils.sortedLinkedListFromOneToN(5),
				CreateUtils.sortedLinkedListFromOneToN(7),
				CreateUtils.sortedLinkedListFromOneToN(20) };

		PrintUtils.printLinkedList(mergeSortedLinkedListsBoosted(Arrays
				.asList(heads)));

		// why no output without reconstructing heads?
		heads = new Node[] { CreateUtils.sortedLinkedListFromOneToN(6),
				CreateUtils.sortedLinkedListFromOneToN(8),
				CreateUtils.sortedLinkedListFromOneToN(5),
				CreateUtils.sortedLinkedListFromOneToN(7),
				CreateUtils.sortedLinkedListFromOneToN(20) };
		Node head = mergeSortedLinkedLists(heads);
		PrintUtils.printLinkedList(head);
	}

}
