package interval;

public class Interval implements Comparable<Interval> {
	public int start;
	public int end;
	public boolean startInclusive;
	public boolean endInclusive;

	public Interval(int start, int end) {
		assert (start <= end);
		this.start = start;
		this.end = end;
		this.startInclusive = true;
		this.endInclusive = true;
	}

	public String toString() {
		return (startInclusive ? "[" : "(") + String.valueOf(start) + ", "
				+ String.valueOf(end) + (endInclusive ? "]" : ")");
	}

	@Override
	public int compareTo(Interval interval) {
		if (start == interval.start)
			return 0;
		else if (start < interval.start)
			return -1;
		else
			return 1;
	}
}
