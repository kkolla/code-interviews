package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CloneLinkedListWithRandomPointer {

	public static class NodeWithRandomPointer extends ListNode {
		public NodeWithRandomPointer random;
		public NodeWithRandomPointer next;

		public NodeWithRandomPointer(int value) {
			super(value);
		}

		public static NodeWithRandomPointer clone(NodeWithRandomPointer head) {
			NodeWithRandomPointer newHead = null;
			NodeWithRandomPointer prev = null;
			Map<NodeWithRandomPointer, NodeWithRandomPointer> map = new HashMap<NodeWithRandomPointer, NodeWithRandomPointer>();

			// first round: create linked list without random pointer,
			// and construct node map
			NodeWithRandomPointer n = head;
			while (n != null) {
				NodeWithRandomPointer node = new NodeWithRandomPointer(n.val);
				if (newHead == null)
					newHead = node;
				if (prev != null)
					prev.next = node;
				map.put(n, node);
				prev = node;
				n = n.next;
			}
			// second round: link random pointers
			n = head;
			while (n != null) {
				if (n.random != null) {
					map.get(n).random = map.get(n.random);
				}
				n = n.next;
			}
			return newHead;
		}
	}

	public static void main(String[] args) {
		NodeWithRandomPointer head = new NodeWithRandomPointer(0);
		NodeWithRandomPointer n1 = new NodeWithRandomPointer(1);
		NodeWithRandomPointer n2 = new NodeWithRandomPointer(2);
		NodeWithRandomPointer n3 = new NodeWithRandomPointer(3);
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		head.random = n3;
		n1.random = null;
		n2.random = n1;
		n3.random = n2;

		NodeWithRandomPointer n = head;
		while (n != null) {
			System.out.println("curr: " + n.val + " random:"
					+ (n.random != null ? n.random.val : "null"));
			n = n.next;
		}

		NodeWithRandomPointer newHead = NodeWithRandomPointer.clone(head);
		n = newHead;
		while (n != null) {
			System.out.println("curr: " + n.val + " random:"
					+ (n.random != null ? n.random.val : "null"));
			n = n.next;
		}
	}

}
