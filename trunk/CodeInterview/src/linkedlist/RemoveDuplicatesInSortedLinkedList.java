package linkedlist;

import utils.PrintUtils;

public class RemoveDuplicatesInSortedLinkedList {

	public static Node removeAndKeepOneIfDuplicated(Node head) {
		Node n = head;
		while (n != null) {
			if (n.next != null && n.next.value == n.value) {
				n.next = n.next.next;
			} else {
				n = n.next;
			}
		}
		return head;
	}

	public static Node removeAllIfDuplicated(Node head) {
		if (head == null || head.next == null)
			return head;
		Node newHead = null;
		Node curr = null;
		Node n = head;
		while (n != null) {
			int value = n.value;
			Node t = n;
			int count = 0;
			while (n != null && value == n.value) {
				n = n.next;
				count++;
			}
			if (count == 1) {
				if (newHead == null) {
					newHead = t;
					curr = t;
				} else {
					curr.next = t;
					curr = curr.next;
				}
			}
		}
		if (newHead == null)
			return null;
		curr.next = null;
		return newHead;
	}

	public static void main(String[] args) {
		Node[] heads = new Node[] {
				new Node(1, null),
				new Node(1, new Node(1, null)),
				new Node(1, new Node(1, new Node(2, null))),
				new Node(1, new Node(2, new Node(2, null))),
				new Node(1, new Node(1, new Node(1, new Node(2,
						new Node(3, new Node(3, new Node(4, new Node(4,
								new Node(5, null))))))))) };
		for (Node head : heads) {
			PrintUtils.printLinkedList(head);
			PrintUtils.printLinkedList(removeAllIfDuplicated(head));
		}
	}
}
