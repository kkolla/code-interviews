package tree;

/*
 * Given a binary tree, populate the next right pointers in each node.
 * You may assume that it is a full binary tree.
 * Each node other than the leaves has two children.
 */
public class PopulatingNextRightPointersInEachNode {

	public class TreeLinkNode extends TreeNode {
		public TreeLinkNode left;
		public TreeLinkNode right;
		public TreeLinkNode next;

		public TreeLinkNode(int v) {
			super(v);
		}
	}

	public void connect(TreeLinkNode root) {
        TreeLinkNode prevHead = root, prevCurr = root; // head and pointer in the previous level
        TreeLinkNode currHead = null, curr = null; // head and pointer in the current level;
        
        while (prevHead != null) {
            while (prevCurr != null) {
                if (currHead == null) {
                    // in a perfect binary tree, the head of current level is always the left child of previous head
                    currHead = prevHead.left;
                    curr = currHead;
                } else {
                    // current head was assigned before, so current must have been assigned as well
                    curr.next = prevCurr.left;
                    curr = curr.next;
                }
                
                if (curr != null) { // not in the lowest level
                    curr.next = prevCurr.right;
                    curr = curr.next;
                }
                
                prevCurr = prevCurr.next;
            }
            prevHead = currHead;
            prevCurr = prevHead;
            currHead = null;
        }
    }
    
    public void connectRecursive(TreeLinkNode root) {
        if (root == null) return;
        if (root.left != null) root.left.next = root.right;
        if (root.right != null && root.next != null) root.right.next = root.next.left;
        connectRecursive(root.left);
        connectRecursive(root.right);
    }
}
