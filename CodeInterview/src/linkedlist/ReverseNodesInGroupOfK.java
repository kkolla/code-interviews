package linkedlist;

import utils.CreateUtils;
import utils.PrintUtils;

/*
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesInGroupOfK {

	// cannot pass large input, TLE?
	public static Node reverseByGroup(Node head, int k) {
		if (head == null || k == 1)
			return head;
		int length = 0;
		Node curr = head;
		while (curr != null) {
			length++;
			curr = curr.next;
		}
		int times = length / k;
		if (times == 0)
			return head;

		curr = head;
		Node prevTail = null, currTail = null, currHead = null;
		Node newHead = null;
		for (int i = 0; i < times; i++) {
			Node prev = null;
			for (int j = 0; j < k; j++) {
				Node next = curr.next;
				curr.next = prev;
				prev = curr;
				if (j == 0) {
					currTail = curr;
				} else if (j == k - 1) {
					currHead = curr;
				}
				curr = next;
			}
			if (newHead == null) {
				newHead = currHead;
			}
			if (prevTail != null)
				prevTail.next = currHead;
			prevTail = currTail;
		}
		currTail.next = curr;
		return newHead;
	}

	public static void main(String[] args) {
		for (int i = 1; i < 9; i++) {
			Node head = CreateUtils.sortedLinkedListFromOneToN(7);
			PrintUtils.printLinkedList(reverseByGroup(head, i));
		}
	}

}
