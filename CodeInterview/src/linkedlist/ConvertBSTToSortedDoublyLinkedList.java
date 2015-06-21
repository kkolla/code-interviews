package linkedlist;

import java.util.Stack;

import utils.CreateUtils;
import utils.PrintUtils;

public class ConvertBSTToSortedDoublyLinkedList {

	// O(n)?
	public static linkedlist.ListNode convert(tree.Node root) {
		if (root == null)
			return null;
		linkedlist.ListNode head = null;
		linkedlist.ListNode prev = null;
		Stack<tree.Node> s = new Stack<tree.Node>();
		tree.Node n = root;
		while (!s.isEmpty() || n != null) {
			if (n != null) {
				s.push(n);
				n = n.left;
			} else {
				n = s.pop();
				linkedlist.ListNode curr = new linkedlist.ListNode(n.value);
				curr.prev = prev;
				if (prev == null) {
					head = curr;
				} else {
					prev.next = curr;
				}
				head.prev = curr;
				curr.next = head;
				prev = curr;
				n = n.right;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		tree.Node root = CreateUtils.bstWithTenNodes();
		ListNode head = convert(root);
		PrintUtils.printBinaryTree(root);
		ListNode t = head;
		do {
			System.out.print(t.val + " ");
			t = t.next;
		} while (t != head);
	}

}
