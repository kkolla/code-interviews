package linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                return new Integer(n1.val).compareTo(new Integer(n2.val));
            }
        });
        
        for (ListNode n : lists) {
            if (n != null) {
                pq.add(n);
            }
        }
        
        ListNode head = pq.peek(), prev = head;
        while (!pq.isEmpty()) {
            ListNode n = pq.poll();
            if (prev != null) prev.next = n;
            if (n.next != null) pq.add(n.next);
            prev = n;
        }
        
        return head;
    }
}
