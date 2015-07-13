package linkedlist;

/**
 * Remove all elements from a linked list of integers that have value val.
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 *
 */
public class RemoveTargetInLinkedList {

	public ListNode removeElements(ListNode head, int val) {
        ListNode prev = null, n = head, newHead = head;
        while (n != null) {
            if (n.val == val) {
                if (prev != null) {
                    prev.next = n.next;
                } else {
                    newHead = n.next;
                }
            } else {
                prev = n;
            }
            n = n.next;
        }
        return newHead;
    }
	
	// shorter: http://www.programcreek.com/2014/04/leetcode-remove-linked-list-elements-java/
}
