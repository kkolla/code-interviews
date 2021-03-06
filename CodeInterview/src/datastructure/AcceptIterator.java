package datastructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Given
 * interface Iterator<T> {
 * 		T next();
 * 		boolean hasNext();
 * }
 * interface Predicate<T> {
 * 		boolean accept(T t);
 * }
 * Implement a method that creates an "accept" iterator that returns items 
 * accepted by the passedin pred variable.
 * Iterator<T> conditionIterator<T>(Iterator<T> input, Predicate<T> pred) { }
 }
 */
public class AcceptIterator<T> implements Iterator<T> {

	interface Predicate<T> {
		public boolean accept(T t);
	}

	public static class PredicateImpl implements Predicate<Integer> {
		public boolean accept(Integer a) {
			return a % 2 == 0;
		}
	}

	Iterator<T> iter;
	Predicate<T> pred;
	T next;

	public AcceptIterator(Iterator<T> iterator, Predicate<T> predicate) {
		iter = iterator;
		pred = predicate;
		updateNext();
	}

	private void updateNext() {
		next = null;
		while (iter.hasNext()) {
			T t = iter.next();
			if (pred.accept(t)) {
				next = t;
				break;
			}
		}
	}

	@Override
	public boolean hasNext() {
		return next != null;
	}

	@Override
	public T next() {
		T t = next;
		updateNext();
		return t;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
	}

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++)
			l.add(i);
		Iterator<Integer> iter = l.iterator();
		Predicate<Integer> pred = new PredicateImpl();
		Iterator<Integer> it = new AcceptIterator<Integer>(iter, pred);
		System.out.println(it.hasNext());
		System.out.println(it.hasNext());
		System.out.println(it.hasNext());
		System.out.println(it.hasNext());
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println(it.hasNext());
		System.out.println(it.hasNext());
		System.out.println(it.hasNext());
		System.out.println(it.hasNext());
	}
}
