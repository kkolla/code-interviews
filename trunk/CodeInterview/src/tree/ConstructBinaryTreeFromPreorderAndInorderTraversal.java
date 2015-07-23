package tree;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, 0, preorder.length);
    }
    
    private TreeNode buildTree(int[] preorder, int[] inorder, int preorderStart, int inorderStart, int len) {
        if (len <= 0) return null;
        TreeNode root = new TreeNode(preorder[preorderStart]);
        int rootIndexInorder = -1;
        for (int i = inorderStart; i < inorderStart + len; i++) {
            if (inorder[i] == root.val) {
                rootIndexInorder = i;
                break;
            }
        }
        int leftLen = rootIndexInorder - inorderStart;
        root.left = buildTree(preorder, inorder, preorderStart + 1, inorderStart, leftLen);
        root.right = buildTree(preorder, inorder, preorderStart + 1 + leftLen, rootIndexInorder + 1, len - leftLen - 1);
        return root;
    }
}
