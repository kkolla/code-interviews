package tree;

public class SegmentTreeQueryII {
	public int query(SegmentTreeNode root, int start, int end) {
		if (root == null || start > root.end || end < root.start) return 0;
        if (root.start >= start && root.end <= end) return root.count;
        return query(root.left, start, end) + query(root.right, start, end);
    }
}
