package linkedlist;

/*
 * Given a linked list, remove the nth node from the 
 * end of list and return its head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, 
 * the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */
public class RemoveTheNthNodeFromEnd {

	public static Node remove(Node head, int n) {
		if (head == null)
			return null;
		Node slow = head, fast = head;
		for (int i = 1; i < n; i++)
			fast = fast.next;
		if (fast.next == null)
			return head = head.next;
		Node prev = null;
		while (fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next;
		}
		prev.next = slow.next;
		return head;
	}

}
