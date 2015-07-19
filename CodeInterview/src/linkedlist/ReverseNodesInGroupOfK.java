package linkedlist;

import utils.CreateUtils;
import utils.PrintUtils;

/*
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesInGroupOfK {
	
    public ListNode reverseKGroup(ListNode head, int k) {
		ListNode n = head, groupHead = head, newHead = null, prevGroupTail = null;
        int count = 0;
        while (n != null) {
            count++;
            if (count == k) {
                ListNode next = n.next;
                n.next = null;
                ListNode oldGroupHead = groupHead;
                groupHead = reverse(groupHead);
                if (newHead == null) newHead = groupHead;
                if (prevGroupTail != null) prevGroupTail.next = groupHead;
                prevGroupTail = oldGroupHead;
                groupHead = next;
                n = next;
                count = 0;
            } else {
                n = n.next;
            }
        }
        if (prevGroupTail != null) prevGroupTail.next = groupHead;
        
        return newHead == null ? head : newHead;
	}
    
    private static ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

	public static ListNode reverseByGroup(ListNode head, int k) {
		if (head == null || k == 1)
			return head;
		int length = 0;
		ListNode curr = head;
		while (curr != null) {
			length++;
			curr = curr.next;
		}
		int times = length / k;
		if (times == 0)
			return head;

		curr = head;
		ListNode prevTail = null, currTail = null, currHead = null;
		ListNode newHead = null;
		for (int i = 0; i < times; i++) {
			ListNode prev = null;
			for (int j = 0; j < k; j++) {
				ListNode next = curr.next;
				curr.next = prev;
				prev = curr;
				if (j == 0) {
					currTail = curr;
				} else if (j == k - 1) {
					currHead = curr;
				}
				curr = next;
			}
			if (newHead == null) {
				newHead = currHead;
			}
			if (prevTail != null)
				prevTail.next = currHead;
			prevTail = currTail;
		}
		currTail.next = curr;
		return newHead;
	}

	public static void main(String[] args) {
		for (int i = 1; i < 9; i++) {
			ListNode head = CreateUtils.sortedLinkedListFromOneToN(7);
			PrintUtils.printLinkedList(reverseByGroup(head, i));
		}
	}

}
