package tree;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0 , nums.length - 1);    
    }
    
    public TreeNode sortedArrayToBST(int[] nums, int low, int high) {
        if (low > high) return null;
        int len = high - low + 1;
        int mid = low + len / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, low, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, high);
        return root;
    }
}
