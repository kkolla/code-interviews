package linkedlist;

import utils.CreateUtils;

public class PrintLinkedListInReversedOrder {

	public static void print(Node head) {
		if (head == null)
			return;
		print(head.next);
		System.out.println(head.value);
	}

	public static void main(String[] args) {
		print(CreateUtils.sortedLinkedListFromOneToN(10));
	}

}
