package tree;

/** 
 * For an integer array (index from 0 to n-1, where n is the size of this array), 
 * in the corresponding SegmentTree, each node stores an extra attribute max to denote the maximum number in the interval of the array (index from start to end).
 * Design a query method with three parameters root, start and end, find the maximum number in the interval [start, end] by the given root of segment tree.
 *
 */
public class SegmentTreeQuery {
	public int query(SegmentTreeNode root, int start, int end) {
        if (root.start >= start && root.end <= end) return root.max;
        
        int leftEnd = (root.start + root.end) / 2;
        int rightStart = (root.start + root.end) / 2 + 1;
        if (start > leftEnd) 
            return query(root.right, start, end);
        else if (end < rightStart) 
            return query(root.left, start, end);
        else 
            return Math.max(
            		query(root.left, start, leftEnd), 
            		query(root.right, rightStart, end));
    }
}
