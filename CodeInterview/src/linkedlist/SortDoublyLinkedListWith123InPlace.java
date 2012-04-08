package linkedlist;

/* not tested yet */
public class SortDoublyLinkedListWith123InPlace {
	public static Node sort(Node head) {

		if (head == null || head.next == null)
			return head;

		Node one = null, two = null, three = null;

		Node n = head;

		while (n != null) {

			if (n.value == 1 && one == null)
				one = n;

			else if (n.value == 2 && two == null)
				two = n;

			else if (n.value == 3 && three == null)
				three = n;

			n = n.next;

		}

		n = head;

		Node t1 = one, t2 = two, t3 = three;
		insertNode(t2, three);

		insertNode(t1, two);

		while (n != null) {

			if (n != t1 && n != t2 && n != t3) {

				deleteNode(head, n);

				if (n.value == 1)
					t1 = insertNode(t1, n);

				else if (n.value == 2)
					t2 = insertNode(t2, n);

				else if (n.value == 3)
					t3 = insertNode(t3, n);

			}

			n = n.next;

		}

		return one != null ? one : (two != null ? three : t3);

	}

	public static void deleteNode(Node head, Node n) {

		if (head == null || n == null)
			return;

		if (head == n)
			head = n.next;

		if (n.next != null)
			n.next.prev = n.prev;

		if (n.prev != null)
			n.prev.next = n.next;

	}

	// insert n after t
	public static Node insertNode(Node t, Node n) {

		if (n == null || t == null || n == t)
			return null;

		if (t.next == null) {
			n.next = null;
			n.prev = t;
			t.next = n;
		} else {
			t.next.prev = n;
			n.next = t.next;
			t.next = n;
			n.prev = t;
		}

		return n;

	}
}
