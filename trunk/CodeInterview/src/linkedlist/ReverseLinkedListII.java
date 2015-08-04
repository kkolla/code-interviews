package linkedlist;

public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
       if (head == null) return head;
       
       // move to the position where the reversal begins
       int moves = m - 1;
       ListNode curr = head, lastBeforeReverse = null;
       for (int i = 0; i < moves; i++) {
           lastBeforeReverse = curr;
           curr = curr.next;
       }
       
       // reverse the sublist starting from curr
       ListNode sublistHead = null, sublistTail = curr;
       int reverseTimes = n - m + 1;
       for (int i = 0; i < reverseTimes; i++) {
           ListNode next = curr.next;
           curr.next = sublistHead;
           sublistHead = curr;
           curr = next;
       }
       
       if (m != 1) lastBeforeReverse.next = sublistHead;
       sublistTail.next = curr;
       
       return m == 1 ? sublistHead : head; 
    }
}
