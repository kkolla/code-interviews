package array;

import interval.Interval;

import java.util.ArrayList;

/**
 * Given an integer array (index from 0 to n-1, where n is the size of this array), 
 * and an query list. Each query has two integers [start, end]. For each query, 
 * calculate the sum number between index start and end in the given array, 
 * return the result list.
 * 
 * Example
 * For array [1,2,7,8,5], and queries [(0,4),(1,2),(2,4)], return [23,9,20]
 * 
 * Note
 * We suggest you finish problem Segment Tree Build, Segment Tree Query and Segment Tree Modify first.
 * 
 * Challenge
 * O(logN) time for each query
 *
 */
public class IntervalSum {
	// O(n + q) 
    public ArrayList<Long> intervalSum(int[] A, ArrayList<Interval> queries) {
        ArrayList<Long> result = new ArrayList<Long>();
        if (A.length == 0) return result;
                                           
        long[] s = new long[A.length + 1];
        for (int i = 1; i < s.length; i++) {
            s[i] = s[i - 1] + A[i - 1];
        }
        
        for (Interval query : queries) {
            result.add(s[query.end + 1] - s[query.start]);
        }
        
        return result;
    }
}
