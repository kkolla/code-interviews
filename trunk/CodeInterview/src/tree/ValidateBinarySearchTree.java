package tree;

public class ValidateBinarySearchTree {

	public static boolean validate(Node root, int min, int max) {
		if (root == null)
			return true;
		return root.value > min && root.value < max
				&& validate(root.left, min, root.value)
				&& validate(root.right, root.value, max);
	}

	public static void main(String[] args) {
		Node root = Node.createBSTWithTenNodes();
		System.out
				.println(validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		root.value = 100;
		System.out
				.println(validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

}
