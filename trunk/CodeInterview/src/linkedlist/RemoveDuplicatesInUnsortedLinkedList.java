package linkedlist;

import java.util.HashSet;
import java.util.Set;

import utils.CreateUtils;
import utils.PrintUtils;

public class RemoveDuplicatesInUnsortedLinkedList {

	public static Node removeDulicates(Node head) {
		if (head == null || head.next == null)
			return head;
		Set<Integer> set = new HashSet<Integer>();
		Node n = head;
		Node prev = null;
		while (n != null) {
			if (!set.contains(n.value)) {
				set.add(n.value);
				prev = n;
			} else
				prev.next = n.next;
			n = n.next;
		}
		return head;
	}

	public static void main(String[] args) {
		Node head = CreateUtils.randNonNegLinkedList(10, 5);
		PrintUtils.printLinkedList(head);
		PrintUtils.printLinkedList(removeDulicates(head));
	}

}
