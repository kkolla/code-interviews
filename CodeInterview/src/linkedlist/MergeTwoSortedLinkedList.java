package linkedlist;

import utils.CreateUtils;
import utils.PrintUtils;

/*
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes 
 * of the first two lists.
 */
public class MergeTwoSortedLinkedList {

	public static ListNode merge(ListNode head1, ListNode head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		ListNode n1 = head1, n2 = head2;
		ListNode head = head1.val < head2.val ? head1 : head2;
		while (n1 != null && n2 != null) {
			if (n1.val < n2.val) {
				while (n1.next != null && n1.next.val < n2.val)
					n1 = n1.next;
				ListNode t = n1;
				n1 = n1.next;
				t.next = n2;
			} else {
				// pitfall: should be <=, not <
				while (n2.next != null && n2.next.val <= n1.val)
					n2 = n2.next;
				ListNode t = n2;
				n2 = n2.next;
				t.next = n1;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		PrintUtils.printLinkedList(merge(
				merge(CreateUtils.sortedLinkedListFromOneToN(8),
						CreateUtils.sortedLinkedListFromOneToN(5)),
				CreateUtils.sortedLinkedListFromOneToN(7)));
	}

}
