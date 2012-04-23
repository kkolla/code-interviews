package linkedlist;

public class Node implements Comparable<Node> {
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

	@Override
	public int compareTo(Node o) {
		if (value == o.value)
			return 0;
		return value < o.value ? -1 : 1;
	}
}
