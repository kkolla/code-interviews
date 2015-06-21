package linkedlist;

import utils.PrintUtils;

public class ReverseLinkedList {

	public static ListNode reverseLinkedListIterative(ListNode head) {
		ListNode curr = head, prev = null;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public static ListNode reverseLinkedListRecursive(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = reverseLinkedListRecursive(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5,
				null)))));

		PrintUtils.printLinkedList(head);
		PrintUtils.printLinkedList(head = reverseLinkedListIterative(head));
		PrintUtils.printLinkedList(reverseLinkedListRecursive(head));
	}

}
