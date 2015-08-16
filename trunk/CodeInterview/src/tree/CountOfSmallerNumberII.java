package tree;

import java.util.ArrayList;

public class CountOfSmallerNumberII {
	// O(m + nlog(m)), m is the length of the interval
	// so depending on the scale of m and n, this algorithm may or may not be faster than brute-foce
	public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
	    // build a segment tree with range [0, 10000]
        SegmentTreeNode root = buildTree(0, 10000);

        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int num : A) {
           // query before insertion
           int count = queryTree(root, 0, num - 1);
           result.add(count);
            
           // insert element and update count on each tree node
           modifyTree(root, num);
        }
        return result;
    }
    
    private SegmentTreeNode buildTree(int start, int end) {
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
        if (start < end) {
        	int mid = (start + end) / 2;
            root.left = buildTree(start, mid);
            root.right = buildTree(mid + 1, end);
        }
        return root;
    }
    
    private void modifyTree(SegmentTreeNode root, int num) {
        if (root == null || num < root.start || num > root.end) return;
        modifyTree(root.left, num);
        modifyTree(root.right, num);
        root.count = root.start == root.end ? root.count + 1 : root.left.count + root.right.count;
    }
    
    private int queryTree(SegmentTreeNode root, int start, int end) {
        if (root == null || start > root.end || end < root.start) return 0;
        if (root.start >= start && root.end <= end) return root.count;
        return queryTree(root.left, start, end) + queryTree(root.right, start, end);
    }
}
