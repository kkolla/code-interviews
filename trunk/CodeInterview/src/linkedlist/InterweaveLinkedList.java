package linkedlist;

import utils.CreateUtils;
import utils.PrintUtils;

/*
 * Interweave a linked list. Do it in Linear time and constant space. 
 * Input: A->B->C->D->E Output: A->E->B->D->C
 */
public class InterweaveLinkedList {

	public static ListNode interweave(ListNode head) {
		if (head == null || head.next == null)
			return head;
		int length = 0;
		ListNode n = head;
		while (n != null) {
			length++;
			n = n.next;
		}
		ListNode halfHead = head;
		for (int i = 0; i < length / 2; i++)
			halfHead = halfHead.next;
		ListNode prev = null, curr = halfHead;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		halfHead = prev;
		// the length of second half is no less than that of first half
		ListNode first = head, second = halfHead;
		prev = null;
		for (int i = 0; i < length / 2; i++) {
			if (prev != null)
				prev.next = first;
			ListNode nextFirst = first.next;
			first.next = second;
			prev = second;
			first = nextFirst;
			second = second.next;
		}
		return head;
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			ListNode head = CreateUtils.sortedLinkedListFromOneToN(i);
			PrintUtils.printLinkedList(head);
			PrintUtils.printLinkedList(interweave(head));
		}
	}

}
