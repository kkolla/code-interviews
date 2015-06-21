package linkedlist;

import utils.CreateUtils;
import utils.PrintUtils;

public class RotateLinkedListByK {

	public static ListNode rotate(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;
		int length = 0;
		ListNode n = head;
		ListNode last = null;
		while (n != null) {
			length++;
			last = n;
			n = n.next;
		}
		k = k % length;
		if (k == 0)
			return head; // pitfall
		int steps = length - k - 1;
		n = head;
		for (int i = 0; i < steps; i++)
			n = n.next;
		ListNode newHead = n.next;
		n.next = null;
		last.next = head;
		return newHead;
	}

	public static void main(String[] args) {
		ListNode head = CreateUtils.randNonNegLinkedList(10, 10);
		PrintUtils.printLinkedList(head);
		PrintUtils.printLinkedList(rotate(head, 3));
	}

}
