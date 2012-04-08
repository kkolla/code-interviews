package tree;

public class Node {
	public int value;
	public Node left;
	public Node right;
	public Node parent;

	public Node(int v, Node l, Node r) {
		value = v;
		left = l;
		right = r;
	}

	public Node(int v) {
		value = v;
	}

	public Node(int v, Node p) {
		value = v;
		parent = p;
	}

	public String toString() {
		return String.valueOf(value);
	}

	public static Node getBSTWithTenNodes() {
		Node n1 = new Node(1);
		Node n3 = new Node(3);
		Node n2 = new Node(2, n1, n3);
		n1.parent = n3.parent = n2;
		Node n7 = new Node(7);
		Node n10 = new Node(10);
		Node n9 = new Node(9, null, n10);
		n10.parent = n9;
		Node n5 = new Node(5);
		Node n4 = new Node(4, n2, n5);
		n2.parent = n5.parent = n4;
		Node n8 = new Node(8, n7, n9);
		n7.parent = n9.parent = n8;
		Node root = new Node(6, n4, n8);
		n4.parent = n8.parent = root;
		return root;
	}
}
