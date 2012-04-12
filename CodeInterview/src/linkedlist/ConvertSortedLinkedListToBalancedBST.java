package linkedlist;

import utils.CreateUtils;
import utils.PrintUtils;

public class ConvertSortedLinkedListToBalancedBST {

	// O(n) = n/2+2O(n/2) = O(n*log(n))?
	// boost to O(n): save the linked list nodes into an array in advance?
	public static tree.Node convert(linkedlist.Node head, int length) {
		if (head == null)
			return null;

		linkedlist.Node midNode = head;
		for (int i = 0; i < length / 2; i++) {
			midNode = midNode.next;
		}

		int leftLength = length / 2;
		int rightLength = length - leftLength - 1;

		tree.Node root = new tree.Node(midNode.value);
		if (leftLength > 0)
			root.left = convert(head, leftLength);
		if (rightLength > 0)
			root.right = convert(midNode.next, rightLength);

		return root;
	}

	public static void main(String[] args) {
		int length = (int) (Math.random() * 20);
		linkedlist.Node head = CreateUtils
				.createSortedLinkedListFromOneToN(length);
		tree.Node root = convert(head, length);
		PrintUtils.printLinkedList(head);
		PrintUtils.printBinaryTree(root);
	}

}
