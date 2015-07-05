package interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class MergeIntervalsAfterInsertion {

	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();

        for (Interval interval : intervals) {
        	if (newInterval.start > interval.end) {
        		// the interval to insert is later than the current
        		result.add(interval);
        	} else if (newInterval.end < interval.start) {
        		// the interval to insert is before the current
        		result.add(newInterval);
        		// treat the current interval as the new interval to be inserted
        		newInterval = interval;
        	} else {
        		// the interval to insert intersects with the current
        		// construct a new interval with wider span, to be inserted later
        		newInterval.start = Math.min(newInterval.start, interval.start);
        		newInterval.end = Math.max(newInterval.end, interval.end);
        	}
        }
        
        result.add(newInterval);
        
        return result;
    }

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(5, 10));
		intervals.add(new Interval(15, 17));
		intervals.add(new Interval(18, 25));
		
		List<Interval> inserts = new ArrayList<Interval>();
		inserts.add(new Interval(16, 35));
		inserts.add(new Interval(5, 8));
		inserts.add(new Interval(4, 8));
		inserts.add(new Interval(4, 15));
		inserts.add(new Interval(4, 26));
		
		for (Interval insert : inserts) {
			for (Interval interval : insert(intervals, insert))
				System.out.print(interval + " ");
			System.out.println();
		}
	}

}
