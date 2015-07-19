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
			Map<NodeWithRandomPointer, NodeWithRandomPointer> map = new HashMap<NodeWithRandomPointer, NodeWithRandomPointer>();
			NodeWithRandomPointer n1 = head;
			NodeWithRandomPointer dummy = new NodeWithRandomPointer(-1), n2 = dummy;
	        while (n1 != null) {
	        	NodeWithRandomPointer newNode = new NodeWithRandomPointer(n1.val);
	            n2.next = newNode;
	            map.put(n1, newNode);
	            n1 = n1.next;
	            n2 = n2.next;
	        }
	        
	        n1 = head;
	        while (n1 != null) {
	            map.get(n1).random = map.get(n1.random);
	            n1 = n1.next;
	        }
	        
	        return dummy.next;
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
