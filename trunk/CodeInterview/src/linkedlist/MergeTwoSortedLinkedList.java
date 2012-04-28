package linkedlist;

import utils.CreateUtils;
import utils.PrintUtils;

/*
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes 
 * of the first two lists.
 */
public class MergeTwoSortedLinkedList {

	public static Node merge(Node head1, Node head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		Node n1 = head1, n2 = head2;
		Node head = head1.value < head2.value ? head1 : head2;
		while (n1 != null && n2 != null) {
			if (n1.value < n2.value) {
				while (n1.next != null && n1.next.value < n2.value)
					n1 = n1.next;
				Node t = n1;
				n1 = n1.next;
				t.next = n2;
			} else {
				// pitfall: should be <=, not <
				while (n2.next != null && n2.next.value <= n1.value)
					n2 = n2.next;
				Node t = n2;
				n2 = n2.next;
				t.next = n1;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		PrintUtils.printLinkedList(merge(
				CreateUtils.sortedLinkedListFromOneToN(8),
				CreateUtils.sortedLinkedListFromOneToN(5)));
	}

}
