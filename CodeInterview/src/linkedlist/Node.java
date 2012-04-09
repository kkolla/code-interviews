package linkedlist;

public class Node {
	public int value;
	public Node next;
	public Node prev;

	public Node(int value, Node next) {
		this.value = value;
		this.next = next;
	}

	public static Node createLinkedListWithTenNodes() {
		return new Node(1, new Node(2, new Node(3, new Node(4, new Node(5,
				new Node(6, new Node(7, new Node(8, new Node(9, new Node(10,
						null))))))))));
	}

	public static int length(Node head) {
		Node n = head;
		int length = 0;
		while (n != null) {
			length++;
			n = n.next;
		}
		return length;
	}

	public String toString() {
		return "Node (value: " + value + ", next: "
				+ (next == null ? "null" : next.value) + ")";
	}
}
