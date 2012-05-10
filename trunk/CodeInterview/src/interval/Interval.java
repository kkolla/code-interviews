package interval;

public class Interval implements Comparable<Interval> {
	public double begin;
	public double end;
	public boolean beginInclusive;
	public boolean endInclusive;

	public Interval(double begin, double end) {
		assert (begin <= end);
		this.begin = begin;
		this.end = end;
		this.beginInclusive = true;
		this.endInclusive = true;
	}

	public String toString() {
		return (beginInclusive ? "[" : "(") + String.valueOf(begin) + ", "
				+ String.valueOf(end) + (endInclusive ? "]" : ")");
	}

	@Override
	public int compareTo(Interval interval) {
		if (begin == interval.begin)
			return 0;
		else if (begin < interval.begin)
			return -1;
		else
			return 1;
	}
}
