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

	// one pass
	public static ListNode remove(ListNode head, int n) {
		if (head == null)
			return null;
		ListNode slow = head, fast = head;
		for (int i = 1; i < n; i++)
			fast = fast.next;
		if (fast.next == null)
			return head.next;
		ListNode prev = null;
		while (fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next;
		}
		prev.next = slow.next;
		return head;
	}

	// two passes
	ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        
        if (n == len) return head.next;
        
        int moves = len - n - 1;
        node = head;
        for (int i = 0; i < moves; i++) node = node.next;
        if (node.next != null) node.next = node.next.next;
        
        return head;
    }
}
