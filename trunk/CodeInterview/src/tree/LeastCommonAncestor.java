package tree;

public class LeastCommonAncestor {

	public static Node lca(Node root, Node n1, Node n2) {
		if (root == null || root == n1 || root == n2)
			return root;
		Node left = lca(root.left, n1, n2);
		Node right = lca(root.right, n1, n2);
		if (left != null && right != null)
			return root;
		else
			return left != null ? left : right;
	}

	public static void main(String[] args) {
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n2 = new Node(2, n4, n5);
		Node n3 = new Node(3);
		Node root = new Node(1, n2, n3);
		Node ancestor = lca(root, n5, n4);
		System.out.println("LCA's value: " + ancestor.value);
	}

}
