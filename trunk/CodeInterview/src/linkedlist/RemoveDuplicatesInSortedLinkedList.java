package linkedlist;

import utils.PrintUtils;

public class RemoveDuplicatesInSortedLinkedList {

	public static ListNode removeAndKeepOneIfDuplicated(ListNode head) {
		ListNode n = head;
		while (n != null) {
			if (n.next != null && n.next.val == n.val) {
				n.next = n.next.next;
			} else {
				n = n.next;
			}
		}
		return head;
	}

	public static ListNode removeAllIfDuplicated(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode newHead = null;
		ListNode curr = null;
		ListNode n = head;
		while (n != null) {
			int value = n.val;
			ListNode t = n;
			int count = 0;
			while (n != null && value == n.val) {
				n = n.next;
				count++;
			}
			if (count == 1) {
				if (newHead == null) {
					newHead = t;
					curr = t;
				} else {
					curr.next = t;
					curr = curr.next;
				}
			}
		}
		if (newHead == null)
			return null;
		curr.next = null;
		return newHead;
	}

	public static void main(String[] args) {
		ListNode[] heads = new ListNode[] {
				new ListNode(1, null),
				new ListNode(1, new ListNode(1, null)),
				new ListNode(1, new ListNode(1, new ListNode(2, null))),
				new ListNode(1, new ListNode(2, new ListNode(2, null))),
				new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2,
						new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4,
								new ListNode(5, null))))))))) };
		for (ListNode head : heads) {
			PrintUtils.printLinkedList(head);
			PrintUtils.printLinkedList(removeAllIfDuplicated(head));
		}
	}
}
