package interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import utils.PrintUtils;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 *
 */
public class MergeIntervals {
	
	public static List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<Interval>();
		if (intervals.isEmpty()) return result;
        
        // sort intervals by start
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});
		
		Interval prev = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
			// compare the current interval with the previous
			// if they intersect, replace the added one with a wider span
			boolean isIntersected = curr.start <= prev.end;
			if (isIntersected) {
				int newEnd = Math.max(prev.end, curr.end);
				prev = new Interval(prev.start, newEnd);
			} else {
				result.add(prev);
				prev = curr;
			}
		}
		
		result.add(prev);
		return result;
    }

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,3));
		intervals.add(new Interval(2,6));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(15,18));
		PrintUtils.printList(merge(intervals));
	}

}
