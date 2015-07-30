package tree;

public class RecoverBinarySearchTree {
    // time: O(n), space: O(1)
    public void recoverTree(TreeNode root) {
        TreeNode curr = root, n1 = null, n2 = null, pre = null;
        while (curr != null) {
            if (curr.left == null) {
                // if the left child doesn't exist, we should output the current and go to right
                if (pre != null && pre.val > curr.val) {
                    n2 = curr;
                    if (n1 == null) n1 = pre;
                }
                pre = curr;
                curr = curr.right;
            } else {
                // find the rightmost node on the left subtree, which is the predecessor of current
                TreeNode predecessor = curr.left;
                while (predecessor.right != null && predecessor.right != curr) predecessor = predecessor.right;
                if (predecessor.right == null) {
                    // first time visiting here
                    // construct threaded tree
                    predecessor.right = curr;
                    // predecessor is connected, we can go visit the left subtree now
                    curr = curr.left;
                } else {
                    // predecessor.right == curr, second time visiting here, current's predecessor has been visited
                    if (pre != null && pre.val > curr.val) {
                        n2 = curr;
                        if (n1 == null) n1 = pre;
                    }
                    pre = curr;
                    // de-construct the threaded tree
                    predecessor.right = null;
                    curr = curr.right;
                }
            }
        }
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
    
    
    public static TreeNode n1, n2, pre;

    public void recoverTree2(TreeNode root) {
        n1 = null; n2 = null; pre = null;
        recoverTreeInternal(root);
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
    
    // worst case: O(n) space in stack
    private void recoverTreeInternal(TreeNode curr) {
        if (curr == null) return;
        recoverTreeInternal(curr.left);
        if (pre != null && pre.val > curr.val) {
            n2 = curr;
            if (n1 == null) n1 = pre;
        }
        pre = curr;
        recoverTreeInternal(curr.right);
    }
}
