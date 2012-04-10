package utils;

public class CreateUtils {

	public static tree.Node createBSTWithTenNodes() {
		tree.Node n1 = new tree.Node(1);
		tree.Node n3 = new tree.Node(3);
		tree.Node n2 = new tree.Node(2, n1, n3);
		n1.parent = n3.parent = n2;
		tree.Node n7 = new tree.Node(7);
		tree.Node n10 = new tree.Node(10);
		tree.Node n9 = new tree.Node(9, null, n10);
		n10.parent = n9;
		tree.Node n5 = new tree.Node(5);
		tree.Node n4 = new tree.Node(4, n2, n5);
		n2.parent = n5.parent = n4;
		tree.Node n8 = new tree.Node(8, n7, n9);
		n7.parent = n9.parent = n8;
		tree.Node root = new tree.Node(6, n4, n8);
		n4.parent = n8.parent = root;
		return root;
	}

	public static linkedlist.Node createLinkedListWithTenNodes() {
		return new linkedlist.Node(1, new linkedlist.Node(2,
				new linkedlist.Node(3, new linkedlist.Node(4,
						new linkedlist.Node(5,
								new linkedlist.Node(6, new linkedlist.Node(7,
										new linkedlist.Node(8,
												new linkedlist.Node(9,
														new linkedlist.Node(10,
																null))))))))));
	}
}
