package linkedlist;

public class Node {
	public int value;
	public Node next;
	public Node prev;

	public Node() {

	}

	public Node(int value) {
		this.value = value;
	}

	public Node(int value, Node next) {
		this.value = value;
		this.next = next;
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
