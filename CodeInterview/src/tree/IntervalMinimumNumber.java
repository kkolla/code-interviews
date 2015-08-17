package tree;

import interval.Interval;

import java.util.ArrayList;

/**
 * Given an integer array (index from 0 to n-1, where n is the size of this array), 
 * and an query list. Each query has two integers [start, end]. 
 * For each query, calculate the minimum number between index start and 
 * end in the given array, return the result list.
 * 
 * Example
 * For array [1,2,7,8,5], and queries [(1,2),(0,4),(2,4)], return [2,1,5]
 * Note
 * We suggest you finish problem Segment Tree Build, 
 * Segment Tree Query and Segment Tree Modify first.
 * Challenge
 * O(logN) time for each query
 *
 */
public class IntervalMinimumNumber {
	public ArrayList<Integer> intervalMinNumber(int[] A, ArrayList<Interval> queries) {
		SegmentTreeNode root = buildTree(A, 0, A.length - 1);

		ArrayList<Integer> result = new ArrayList<Integer>();
		for (Interval query : queries) {
			result.add(query(root, query.start, query.end));
		}
		return result;
	}

	private SegmentTreeNode buildTree(int[] A, int start, int end) {
		if (start > end) return null;

		SegmentTreeNode root = new SegmentTreeNode(start, end);

		if (start == end) {
			root.min = A[start];
		} else {
			int mid = (start + end) / 2;
			root.left = buildTree(A, start, mid);
			root.right = buildTree(A, mid + 1, end);
			root.min = Math.min((root.left != null ? root.left.min : Integer.MAX_VALUE), 
								(root.right != null ? root.right.min : Integer.MAX_VALUE));
		}

		return root;
	}

	private int query(SegmentTreeNode root, int start, int end) {
		if (root == null || start > root.end || end < root.start) return Integer.MAX_VALUE;
		if (root.start >= start && root.end <= end) return root.min;
		return Math.min(query(root.left, start, end), query(root.right, start, end));
	}
}
