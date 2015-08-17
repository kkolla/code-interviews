package tree;

public class IntervalSumII {
	private SegmentTreeNode root;
    
    public IntervalSumII(int[] A) {
        this.root = buildTree(A, 0, A.length - 1);
    }

    public long query(int start, int end) {
        return query(this.root, start, end);
    }

    public void modify(int index, int value) {
        modify(this.root, index, value);
    }
    
    private SegmentTreeNode buildTree(int[] A, int start, int end) {
        if (start > end) return null;
        
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        
        if (start == end) {
            root.sum = A[start];
        } else {
            int mid = (start + end) / 2;
            root.left = buildTree(A, start, mid);
            root.right = buildTree(A, mid + 1, end);
            root.sum = (root.left != null ? root.left.sum : 0) + (root.right != null ? root.right.sum : 0);
        }
        
        return root;
    }
    
    private long query(SegmentTreeNode root, int start, int end) {
        if (root == null || start > root.end || end < root.start) return 0;
        if (root.start >= start && root.end <= end) return root.sum;
        return query(root.left, start, end) + query(root.right, start, end);
    }
    
    private void modify(SegmentTreeNode root, int index, int value) {
        if (root == null || index > root.end || index < root.start) return;
        if (root.start == root.end && root.start == index) {
            root.sum = value;
        } else {
            modify(root.left, index, value);
            modify(root.right, index, value);
            root.sum = (root.left != null ? root.left.sum : 0) + (root.right != null ? root.right.sum : 0);
        }
    }
}
