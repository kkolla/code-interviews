package tree;

public class FindNextNodeInBinaryTree {

	public static Node nextNode(Node n) {
		if (n == null)
			return null;
		if (n.right != null) {
			Node t = n.right;
			while (t.left != null)
				t = t.left;
			return t;
		} else {
			Node t = n;
			while (t.parent != null) {
				if (t.parent.left == t)
					return t.parent;
				t = t.parent;
			}
			return null;
		}
	}

	public static void main(String[] args) {
		Node root = Node.createBSTWithTenNodes();
		Node first = root;
		while (first.left != null)
			first = first.left;
		while (first != null) {
			System.out.println(first.value);
			first = nextNode(first);
		}
	}

}
