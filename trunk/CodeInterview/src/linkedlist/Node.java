package linkedlist;

public class Node {
	public int value;
	public Node next;

	public Node(int value, Node next) {
		this.value = value;
		this.next = next;
	}

	public static void printLinkedList(Node head) {
		Node n = head;
		while (n != null) {
			System.out.print(n.value + " ");
			n = n.next;
		}
		System.out.println();
	}
}
