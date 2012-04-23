package linkedlist;

import utils.CreateUtils;
import utils.PrintUtils;

public class RotateLinkedListByK {

	public static Node rotate(Node head, int k) {
		if (head == null || head.next == null)
			return head;
		int length = 0;
		Node n = head;
		Node last = null;
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
		Node newHead = n.next;
		n.next = null;
		last.next = head;
		return newHead;
	}

	public static void main(String[] args) {
		Node head = CreateUtils.randNonNegLinkedList(10, 10);
		PrintUtils.printLinkedList(head);
		PrintUtils.printLinkedList(rotate(head, 3));
	}

}
