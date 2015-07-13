package linkedlist;

import utils.CreateUtils;
import utils.PrintUtils;

/*
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes 
 * of the first two lists.
 */
public class MergeTwoSortedLinkedList {

	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode smallerHead = l1.val < l2.val ? l1 : l2;
        ListNode biggerHead = l1.val < l2.val ? l2 : l1;
        smallerHead.next = mergeTwoLists(smallerHead.next, biggerHead);
        return smallerHead;
     }
    
     public ListNode mergeTwoListsIterative(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        curr.next = l1 != null ? l1 : l2;
        
        return dummy.next;
     }

}
