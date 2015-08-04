package linkedlist;

public class SwapPairs {
	public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next;
        ListNode nextHeadToSwap = head.next.next;
        head.next.next = head;
        head.next = swapPairs(nextHeadToSwap);
        return newHead;
    }
    
    public ListNode swapPairsIterative(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode newHead = head.next;
        ListNode prev = null, curr = head;
        while (curr != null && curr.next != null) {
            if (prev != null) prev.next = curr.next;
            prev = curr;
            ListNode nextNext = curr.next.next;
            curr.next.next = curr;
            curr.next = nextNext;
            curr = curr.next;
        }
        return newHead;
    }
}
