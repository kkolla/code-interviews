package linkedlist;

import utils.CreateUtils;
import utils.PrintUtils;

public class InsertionSortLinkedList {
	
	public static ListNode insertionSortLinkedList(ListNode head) {
		ListNode newHead = new ListNode(Integer.MIN_VALUE);
		
		ListNode curr = head;
		while (curr != null) {
			// save the next element in the old list for later use
			ListNode next = curr.next;
			ListNode p = newHead;
			// in the new list, find an element that's bigger than the current element in the old list
			while (p.next != null && p.next.val < curr.val)
				p = p.next;
			// insert the element to the new list
			curr.next = p.next;
			p.next = curr;
			// move the pointer in the old list
			curr = next;
		}
		
		return newHead.next;
	}

	public static void main(String[] args) {
		ListNode head = CreateUtils.randNonNegLinkedList(10, 10);
		PrintUtils.printLinkedList(head);
		PrintUtils.printLinkedList(insertionSortLinkedList(head));
	}

}
