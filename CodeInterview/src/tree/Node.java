package tree;

public class Node {
	public int value;
	public Node left;
	public Node right;

	public Node(int v, Node l, Node r) {
		value = v;
		left = l;
		right = r;
	}
}
