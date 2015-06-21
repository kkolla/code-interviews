package linkedlist;

public class ListNode implements Comparable<ListNode> {
	public int val;
	public ListNode next;
	public ListNode prev;

	public ListNode() {

	}

	public ListNode(int value) {
		this.val = value;
	}

	public ListNode(int value, ListNode next) {
		this.val = value;
		this.next = next;
	}

	public static int length(ListNode head) {
		ListNode n = head;
		int length = 0;
		while (n != null) {
			length++;
			n = n.next;
		}
		return length;
	}

	public String toString() {
		return "Node (value: " + val + ", next: "
				+ (next == null ? "null" : next.val) + ")";
	}

	@Override
	public int compareTo(ListNode o) {
		if (val == o.val)
			return 0;
		return val < o.val ? -1 : 1;
	}
}
