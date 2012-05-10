package interval;

/*
 * insert one interval to non-overlapping intervals
 * print out the merged intervals
 */
public class MergeIntervalsAfterInsertion {

	public static boolean intersect(Interval interval, Interval insert) {
		return Math.max(interval.begin, insert.begin) <= Math.min(interval.end,
				insert.end);
	}

	private static void insertAndMergeIntervals(Interval[] intervals,
			Interval insert) {
		int i = 0;
		while (i < intervals.length) {
			Interval interval = intervals[i];
			if (intersect(interval, insert)) {
				double minBegin = insert.begin;
				double maxEnd = insert.end;
				while (i < intervals.length && intersect(intervals[i], insert)) {
					minBegin = Math.min(minBegin, intervals[i].begin);
					maxEnd = Math.max(maxEnd, intervals[i].end);
					i++;
				}
				System.out.println(new Interval(minBegin, maxEnd));
			} else {
				// no intersection
				// insert interval appears before current interval
				if (interval.begin > insert.end
						&& (i == 0 || insert.begin > intervals[i - 1].end)) {
					System.out.println(insert);
					System.out.println(interval);
				} else {
					System.out.println(interval);
				}
				i++;
			}
		}
	}

	public static void main(String[] args) {
		Interval[] intervals = { new Interval(5, 10), new Interval(15, 17),
				new Interval(18, 25) };
		Interval[] inserts = { new Interval(16, 35), new Interval(5, 8),
				new Interval(4, 8), new Interval(4, 15), new Interval(4, 26) };
		for (Interval insert : inserts) {
			insertAndMergeIntervals(intervals, insert);
			System.out.println();
		}
	}

}
