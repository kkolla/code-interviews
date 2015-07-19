package linkedlist;

import tree.TreeNode;

public class ConvertSortedListToBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        
        ListNode slow = head, fast = head, prevMid = null;
        while (fast != null && fast.next != null) {
            prevMid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode mid = slow;
        prevMid.next = null;
        
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        
        return root;
    }
}
