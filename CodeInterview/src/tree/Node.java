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

}
