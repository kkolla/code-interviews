package tree;

public class Subtree {
	public boolean isSubtree(TreeNode T1, TreeNode T2) {
        if (T2 == null) return true;
        if (T1 == null) return false;
        return isSameTree(T1, T2) || isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
    }
    
    private boolean isSameTree(TreeNode T1, TreeNode T2) {
        if (T1 == null && T2 == null) return true;
        else if (T1 == null || T2 == null) return false;
        else return T1.val == T2.val && isSameTree(T1.left, T2.left) && isSameTree(T1.right, T2.right);
    }
}
