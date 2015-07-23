package linkedlist;

public class IntersectionOfTwoLinkedLists {
	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        int lenA = length(headA);
        int lenB = length(headB);
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++)
                headA = headA.next;
        } else {
            for (int i = 0; i < lenB - lenA; i++)
                headB = headB.next;;
        }
        
        while (headA != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    
    private int length(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}
