package interval;

import java.util.Arrays;

import utils.CreateUtils;
import utils.PrintUtils;

/*
 * A period of time where users login and logout, 
 * given a sets of login and logout time pairs, 
 * write a function that can show the number of users online at any given time.
 */
public class FindUsersInCertainTimePeriod {

	// O(nlog(n))
	public static int users(Interval[] intervals, Interval period) {
		// sort by begin time
		Arrays.sort(intervals);
		PrintUtils.printArray(intervals);
		// find the first login time greater than period begin time
		int t = -1;
		for (int i = 0; i < intervals.length; i++)
			if (intervals[i].begin > period.begin) {
				t = i;
				break;
			}
		// discard the later portion and get a smaller interval array
		// find the first logout time less than period end time
		int count = 0;
		for (int i = 0; i < t; i++) {
			if (intervals[i].end >= period.end) {
				System.out.println(intervals[i]);
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Interval[] intervals = CreateUtils.randNonNegIntIntervals(30, 20);
		int login = CreateUtils.randNonNegInt(10);
		int logout = CreateUtils.randNonNegInt(20);
		Interval period = new Interval(login, logout);
		System.out.println("query interval: " + period);
		System.out.println("number of users in period: "
				+ users(intervals, period));
		// PrintUtils.printArray(intervals);
	}

}
