package datastructure;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

import utils.CreateUtils;

public class QueueWithGetMinInConstTime extends AbstractQueue<Integer> {
	private LinkedList<Integer> queue = new LinkedList<Integer>();
	private Stack<Integer> minPushs = new Stack<Integer>();
	private Stack<Integer> minPops = new Stack<Integer>();

	// O(1), amortized
	public Integer getMin() {
		if (minPushs.isEmpty() && minPops.isEmpty())
			return null;
		if (minPops.isEmpty()) {
			while (!minPushs.isEmpty())
				minPops.push(minPushs.pop());
		}
		return minPops.peek();
	}

	// O(1) amortized?
	@Override
	public boolean offer(Integer e) {
		if (isEmpty()) {
			minPops.push(e);
		} else {
			if (!minPops.isEmpty() && e <= getMin()) {
				minPops.push(e);
			} else if (!minPops.isEmpty()) {
				while (!minPops.isEmpty() && e > minPops.peek())
					minPushs.push(minPops.pop());
				minPushs.push(e);
				while (!minPops.isEmpty())
					minPushs.push(minPops.pop());
			} else {
				while (!minPushs.isEmpty() && e <= minPushs.peek())
					minPops.push(minPushs.pop());
				minPops.push(e);
				while (!minPushs.isEmpty())
					minPops.push(minPushs.pop());
			}
		}
		queue.push(e);
		return true;
	}

	// O(1) amortized
	@Override
	public Integer poll() {
		if (isEmpty())
			return null;
		int n = queue.pop();
		if (n == getMin())
			minPops.pop();
		return n;
	}

	// O(1) amortized
	@Override
	public Integer peek() {
		return queue.peek();
	}

	@Override
	public Iterator<Integer> iterator() {
		return queue.iterator();
	}

	@Override
	public int size() {
		return queue.size();
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public static void main(String[] args) {
		QueueWithGetMinInConstTime q = new QueueWithGetMinInConstTime();
		for (int i = 0; i < 20; i++) {
			if (Math.random() > 0.3) {
				int n = CreateUtils.randNonNegInt(100);
				q.offer(n);
				System.out.println(n + " added, getMin: " + q.getMin());
			} else {
				System.out.println(q.poll() + " poped, getMin: " + q.getMin());
			}
		}
	}

}
