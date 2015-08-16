package tree;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Give you an integer array (index from 0 to n-1, where n is the size of this array, 
 * value from 0 to 10000) and an query list. For each query, give you an integer, 
 * return the number of element in the array that are smaller that the given integer.
 * 
 * Example
 * For array [1,2,7,8,5], and queries [1,8,5], return [0,4,2]
 * 
 * Note
 * We suggest you finish problem Segment Tree Build and Segment Tree Query II first.
 * 
 * Challenge
 * Could you use three ways to do it.
 * Just loop
 * Sort and binary search
 * Build Segment Tree and Search.
 *
 */
public class CountOfSmallerNumber {
    
    // O(?)
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // build a segment tree with range [0, 10000]
        SegmentTreeNode root = buildTree(0, 10000);

        // insert elements and update count on each tree node
        for (int num : A) {
           modifyTree(root, num); 
        }

        // query [0, queries[i] - 1] to get answer
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int query : queries) {
            int count = queryTree(root, 0, query - 1);
            result.add(count);
        }
        return result;
    }
    
    private SegmentTreeNode buildTree(int start, int end) {
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
        if (start < end) {
            root.left = buildTree(start, (start + end) / 2);
            root.right = buildTree((start + end) / 2 + 1, end);
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
    
    // O(nlog(n)) + O(qlog(n)) = O(Max(q, n) * log(n))
    public ArrayList<Integer> countOfSmallerNumberBinarySearch(int[] A, int[] queries) {
        Arrays.sort(A);
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int query : queries) {
            int l = 0, r = A.length - 1;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (A[m] == query && (m == 0 || A[m] != A[m - 1])) { // for duplicates
                    result.add(m);
                    break;
                } else if (A[m] >= query) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            if (l > r) result.add(l);
        }
        return result;
    }
}
