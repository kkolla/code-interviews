package datastructure;

import java.util.Stack;

import utils.CreateUtils;

public class StackWithGetMinInConstTime<T extends Comparable<T>> extends
		Stack<T> {
	Stack<T> mins;

	public StackWithGetMinInConstTime() {
		super();
		mins = new Stack<T>();
	}

	@Override
	public T push(T element) {
		T top = isEmpty() ? null : peek();
		super.push(element);
		if (mins.isEmpty() || element.compareTo(mins.peek()) <= 0)
			mins.push(element);
		return top;
	}

	@Override
	public T pop() {
		T top = super.pop();
		if (top.compareTo(mins.peek()) == 0)
			mins.pop();
		return top;
	}

	public T getMin() {
		// throw exception or return null when stack is empty?
		return mins.peek();
	}

	public static void main(String[] args) {
		StackWithGetMinInConstTime s = new StackWithGetMinInConstTime();
		for (int i = 0; i < 20; i++) {
			if (Math.random() > 0.3) {
				int n = CreateUtils.randNonNegInt(100);
				s.push(n);
				System.out.println(n + " added, getMin: " + s.getMin());
			} else {
				System.out.println(s.pop() + " poped, getMin: " + s.getMin());
			}
		}
	}

}
