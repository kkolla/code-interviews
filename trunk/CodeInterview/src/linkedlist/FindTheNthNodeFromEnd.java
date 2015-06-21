package linkedlist;

import utils.CreateUtils;
import utils.PrintUtils;

public class FindTheNthNodeFromEnd {

	public static ListNode findNthNodeToLastIterative(ListNode head, int n) {
		int length = ListNode.length(head);
		if (n > length || length == 0)
			return null;
		int steps = length - n;
		ListNode node = head;
		while (steps > 0) {
			node = node.next;
			steps--;
		}
		return node;
	}

	public static ListNode findNthNodeToLastRecursive(ListNode head, int n, int remain) {
		if (remain < 0 || head == null)
			return null;

		if (remain == n)
			return head;
		else
			return findNthNodeToLastRecursive(head.next, n, remain - 1);
	}

	public static void main(String[] args) {
		ListNode head = CreateUtils.sortedLinkedListFromOneToN(10);
		int n = 8;
		PrintUtils.printLinkedList(head);

		System.out.println(findNthNodeToLastRecursive(head, n,
				ListNode.length(head)));
		System.out.println(findNthNodeToLastRecursive(head, n + 1,
				ListNode.length(head)));
		System.out.println(findNthNodeToLastRecursive(head, n + 2,
				ListNode.length(head)));
		System.out.println(findNthNodeToLastRecursive(head, n + 3,
				ListNode.length(head)));
		System.out.println(findNthNodeToLastRecursive(head, 0,
				ListNode.length(head)));

		System.out.println(findNthNodeToLastIterative(head, n));
		System.out.println(findNthNodeToLastIterative(head, n + 1));
		System.out.println(findNthNodeToLastIterative(head, n + 2));
		System.out.println(findNthNodeToLastIterative(head, n + 3));
		System.out.println(findNthNodeToLastIterative(head, 0));
	}

}
