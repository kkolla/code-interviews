package interval;

public class Interval {
	public double begin;
	public double end;
	public boolean beginInclusive;
	public boolean endInclusive;

	public Interval(double begin, double end) {
		this.begin = begin;
		this.end = end;
		this.beginInclusive = true;
		this.endInclusive = true;
	}

	public String toString() {
		return (beginInclusive ? "[" : "(") + String.valueOf(begin) + ", "
				+ String.valueOf(end) + (endInclusive ? "]" : ")");
	}
}
