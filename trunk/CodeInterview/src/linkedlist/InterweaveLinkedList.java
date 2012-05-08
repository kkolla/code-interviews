package linkedlist;

import utils.CreateUtils;
import utils.PrintUtils;

/*
 * Interweave a linked list. Do it in Linear time and constant space. 
 * Input: A->B->C->D->E Output: A->E->B->D->C
 */
public class InterweaveLinkedList {

	public static Node interweave(Node head) {
		if (head == null || head.next == null)
			return head;
		int length = 0;
		Node n = head;
		while (n != null) {
			length++;
			n = n.next;
		}
		Node halfHead = head;
		for (int i = 0; i < length / 2; i++)
			halfHead = halfHead.next;
		Node prev = null, curr = halfHead;
		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		halfHead = prev;
		// the length of second half is no less than that of first half
		Node first = head, second = halfHead;
		prev = null;
		for (int i = 0; i < length / 2; i++) {
			if (prev != null)
				prev.next = first;
			Node nextFirst = first.next;
			first.next = second;
			prev = second;
			first = nextFirst;
			second = second.next;
		}
		return head;
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			Node head = CreateUtils.sortedLinkedListFromOneToN(i);
			PrintUtils.printLinkedList(head);
			PrintUtils.printLinkedList(interweave(head));
		}
	}

}
