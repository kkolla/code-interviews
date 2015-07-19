package linkedlist;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast == null) break;
            slow = slow.next;
        }
        
        ListNode secondHalfHead = slow.next;
        slow.next = null;
        secondHalfHead = reverse(secondHalfHead);
        while (secondHalfHead != null) {
            if (head.val != secondHalfHead.val) return false;
            head = head.next;
            secondHalfHead = secondHalfHead.next;
        }
        
        // restore the original list (optional)
        secondHalfHead = reverse(secondHalfHead);
        slow.next = secondHalfHead;
        
        return true;
    }
    

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
