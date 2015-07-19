package linkedlist;

public class DetectCycleII {
	public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (slow != fast) return null;
        
        int cycleLen = 1;
        while (slow.next != fast) {
            slow = slow.next;
            cycleLen++;
        }
        
        slow = head;
        fast = head;
        for (int i = 0; i < cycleLen; i++)
            fast = fast.next;
        
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
