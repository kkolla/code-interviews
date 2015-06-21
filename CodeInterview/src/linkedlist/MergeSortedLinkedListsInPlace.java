package linkedlist;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import utils.CreateUtils;
import utils.PrintUtils;
import datastructure.Pair;

public class MergeSortedLinkedListsInPlace {

	// O(kn)
	public static ListNode mergeSortedLinkedLists(ListNode[] heads) {
		ListNode head = null;
		ListNode iter = null;
		while (true) {
			// keep doing the logic until all heads are null
			boolean allHeadsNull = true;
			for (ListNode h : heads)
				if (h != null)
					allHeadsNull = false;
			if (allHeadsNull)
				break;

			ListNode smallest = null;
			int smallestHeadIndex = -1;
			for (int i = 0; i < heads.length; i++) {
				ListNode h = heads[i];
				if (h == null)
					continue;
				if (smallest == null || h.val < smallest.val) {
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
	public static ListNode mergeSortedLinkedListsBoosted(List<ListNode> heads) {
		if (heads == null || heads.size() == 0) {
			return null;
		}
		PriorityQueue<ListNode> q = new PriorityQueue<ListNode>();
		ListNode head = null, curr = null;
		int finished = 0;
		for (int i = 0; i < heads.size(); i++) {
			if (heads.get(i) != null)
				q.add(heads.get(i));
			else
				finished++;
		}
		while (finished < heads.size()) {
			ListNode n = q.poll();
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
		ListNode[] heads = new ListNode[] { CreateUtils.sortedLinkedListFromOneToN(6),
				CreateUtils.sortedLinkedListFromOneToN(8),
				CreateUtils.sortedLinkedListFromOneToN(5),
				CreateUtils.sortedLinkedListFromOneToN(7),
				CreateUtils.sortedLinkedListFromOneToN(20) };

		PrintUtils.printLinkedList(mergeSortedLinkedListsBoosted(Arrays
				.asList(heads)));

		// why no output without reconstructing heads?
		heads = new ListNode[] { CreateUtils.sortedLinkedListFromOneToN(6),
				CreateUtils.sortedLinkedListFromOneToN(8),
				CreateUtils.sortedLinkedListFromOneToN(5),
				CreateUtils.sortedLinkedListFromOneToN(7),
				CreateUtils.sortedLinkedListFromOneToN(20) };
		ListNode head = mergeSortedLinkedLists(heads);
		PrintUtils.printLinkedList(head);
	}

}
