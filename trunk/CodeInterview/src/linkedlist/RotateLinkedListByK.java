package linkedlist;

import utils.CreateUtils;
import utils.PrintUtils;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 *
 */
public class RotateLinkedListByK {

	public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        
        k = k >= 0 ? k % len : (k % len + len) % len;
        if (k == 0) return head;

        ListNode newTail = head;
        for (int i = 0; i < len - k - 1; i++) newTail = newTail.next;
        
        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;
        
        return newHead;
    }

	public static void main(String[] args) {
		ListNode head = CreateUtils.randNonNegLinkedList(10, 10);
		PrintUtils.printLinkedList(head);
		PrintUtils.printLinkedList(rotateRight(head, -24));
		System.out.println(-13%2);
	}

}
