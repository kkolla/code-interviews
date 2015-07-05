package interval;

import java.util.Arrays;
import java.util.Comparator;

import utils.CreateUtils;
import utils.PrintUtils;

public class FindANumberWithinMostIntervals {

	public static class IntervalPoint {
		double value;
		boolean isBegin;

		public IntervalPoint(double value, boolean isBegin) {
			this.value = value;
			this.isBegin = isBegin;
		}
	}

	public static double findNumber(Interval[] intervals) {
		double number = Double.NaN;
		IntervalPoint[] points = new IntervalPoint[2 * intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			points[2 * i] = new IntervalPoint(intervals[i].start, true);
			points[2 * i + 1] = new IntervalPoint(intervals[i].end, false);
		}
		Arrays.sort(points, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				IntervalPoint p1 = (IntervalPoint) o1;
				IntervalPoint p2 = (IntervalPoint) o2;
				if (p1.value == p2.value)
					return 0;
				else if (p1.value < p2.value)
					return -1;
				else
					return 1;
			}
		});
		int intersections = 0;
		int maxIntersections = 0;
		double begin = Double.MAX_VALUE;
		for (int i = 0; i < points.length; i++) {
			IntervalPoint p = points[i];
			if (p.isBegin) {
				intersections++;
				if (intersections > maxIntersections) {
					maxIntersections = intersections;
					begin = p.value;
				}
			} else {
				if (intersections == maxIntersections) {
					double end = p.value;
					number = (begin + end) / 2;
				}
				intersections--;
			}
		}
		return number;
	}

	public static void main(String[] args) {
		Interval[] intervals = CreateUtils.randNonNegIntIntervals(8, 50);
		PrintUtils.printArray(intervals);
		System.out.println(findNumber(intervals));
	}

}
