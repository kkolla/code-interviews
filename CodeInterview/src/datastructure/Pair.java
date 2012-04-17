package datastructure;

public class Pair<F extends Comparable<F>, S extends Comparable<S>> implements
		Comparable<Pair<F, S>> {
	public F first;
	public S second;

	public Pair(F f, S s) {
		first = f;
		second = s;
	}

	@Override
	public int compareTo(Pair<F, S> o) {
		return first.compareTo(o.first);
	}
}
