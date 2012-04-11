package datastructure;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class PriorityQueue<E extends Comparable<E>> extends AbstractQueue<E> {
	private ArrayList<E> heap;
	private Comparator<E> comparator;

	public PriorityQueue() {
		heap = new ArrayList<E>();
		comparator = null;
	}

	public PriorityQueue(Comparator<E> c) {
		heap = new ArrayList<E>();
		comparator = c;
	}

	private int parent(int k) {
		if (k % 2 == 0)
			return k / 2 - 1;
		else
			return k / 2;
	}

	private int leftChild(int k) {
		if (k == 0)
			return 1;
		return 2 * k + 1;
	}

	private int rightChild(int k) {
		if (k == 0)
			return 2;
		return 2 * k + 2;
	}

	private boolean isLessThan(int i, int j) {
		if (comparator != null) {
			return comparator.compare(heap.get(i), heap.get(j)) == -1;
		} else {
			return heap.get(i).compareTo(heap.get(j)) < 0;
		}
	}

	/*
	 * exchange the i-th and j-th heap elements
	 */
	private void exchange(int i, int j) {
		E temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}

	@Override
	public void clear() {
		heap.clear();
	}

	@Override
	public boolean offer(E e) {
		heap.add(e);
		// fix up heap
		int k = size() - 1;
		// if parent > inserted, exchange
		int parent;
		while ((parent = parent(k)) != -1 && isLessThan(k, parent)) {
			exchange(parent, k);
			k = parent;
		}
		return true;
	}

	@Override
	public E peek() {
		if (size() == 0)
			return null;
		return heap.get(0);
	}

	@Override
	public E poll() {
		E e;
		int size = size();
		switch (size) {
		case 0:
			return null;
		case 1: {
			e = heap.remove(0);
			return e;
		}
		default: {
			// fix down heap
			exchange(0, size - 1);
			e = heap.remove(size - 1);
			size = size - 1;
			int k = 0;
			while (leftChild(k) < size) {
				int leftChild = leftChild(k);
				int rightChild = rightChild(k);
				;
				int smallChild = leftChild;
				if (rightChild < size) {
					if (isLessThan(rightChild, leftChild)) {
						smallChild = rightChild;
					}
				}
				if (isLessThan(k, smallChild)) {
					break;
				}
				exchange(k, smallChild);
				k = smallChild;
			}
			return e;
		}
		}
	}

	@Override
	public Iterator<E> iterator() {
		return heap.iterator();
	}

	@Override
	public int size() {
		return heap.size();
	}
}