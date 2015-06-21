package tree;

import utils.CreateUtils;
import utils.PrintUtils;

public class ConvertSortedLinkedListToBalancedBST {

	// O(n) = n/2+2O(n/2) = O(n*log(n))?
	// boost to O(n): save the linked list nodes into an array in advance?
	public static tree.TreeNode convert(linkedlist.ListNode head, int length) {
		if (head == null)
			return null;

		linkedlist.ListNode midNode = head;
		for (int i = 0; i < length / 2; i++) {
			midNode = midNode.next;
		}

		int leftLength = length / 2;
		int rightLength = length - leftLength - 1;

		tree.TreeNode root = new tree.TreeNode(midNode.val);
		if (leftLength > 0)
			root.left = convert(head, leftLength);
		if (rightLength > 0)
			root.right = convert(midNode.next, rightLength);

		return root;
	}

	public static void main(String[] args) {
		int length = CreateUtils.randNonNegInt(20);
		linkedlist.ListNode head = CreateUtils
				.sortedLinkedListFromOneToN(length);
		tree.TreeNode root = convert(head, length);
		PrintUtils.printLinkedList(head);
		PrintUtils.printBinaryTree(root);
	}

}
