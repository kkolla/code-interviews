package linkedlist;

import java.util.HashSet;
import java.util.Set;

import utils.CreateUtils;
import utils.PrintUtils;

public class RemoveDuplicatesInUnsortedLinkedList {

	public static ListNode removeDulicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		Set<Integer> set = new HashSet<Integer>();
		ListNode n = head;
		ListNode prev = null;
		while (n != null) {
			if (!set.contains(n.val)) {
				set.add(n.val);
				prev = n;
			} else
				prev.next = n.next;
			n = n.next;
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode head = CreateUtils.randNonNegLinkedList(10, 5);
		PrintUtils.printLinkedList(head);
		PrintUtils.printLinkedList(removeDulicates(head));
	}

}
