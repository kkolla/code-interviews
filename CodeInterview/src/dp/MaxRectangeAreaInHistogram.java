package dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import utils.CreateUtils;
import utils.PrintUtils;

/*
 * http://tech-queries.blogspot.com/2011/03/maximum-area-rectangle-in-histogram.html
 */
public class MaxRectangeAreaInHistogram {

	// widths[i]: the maximum width of rectangle containing the i-th histogram
	// widths[i] = leftOffset + rightOffset + 1
	// h[i-leftOffset] is the leftmost histogram whose height is at least h[i]
	// answer: max(h[i]*width[i])
	// complexity: O(2n), O(n)
	public static int maxArea(int[] h) {
		int[] widths = new int[h.length];
		Stack<Integer> s = new Stack<Integer>();
		Map<Integer, Integer> left = new HashMap<Integer, Integer>();
		Map<Integer, Integer> right = new HashMap<Integer, Integer>();
		for (int i = 0; i < h.length; i++) {
			while (!s.isEmpty() && h[s.peek()] > h[i])
				s.pop();
			int leftOffset = s.isEmpty() ? i : i - s.peek() - 1;
			widths[i] += leftOffset;
			left.put(i, i - leftOffset);
			s.push(i);
		}
		s = new Stack<Integer>();
		for (int i = h.length - 1; i >= 0; i--) {
			while (!s.isEmpty() && h[s.peek()] > h[i])
				s.pop();
			int rightOffset = s.isEmpty() ? h.length - i - 1 : s.peek() - i - 1;
			widths[i] += rightOffset + 1;
			right.put(i, i + rightOffset);
			s.push(i);
		}
		int start = -1, end = -1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < h.length; i++) {
			int area = widths[i] * h[i];
			if (area > max) {
				max = area;
				start = left.get(i);
				end = right.get(i);
			}
		}
		System.out.println("start: " + start + " end: " + end);
		return max;
	}

	public static void main(String[] args) {
		int[] h = CreateUtils.createRandomIntArray(10, 10);
		for (int i = 0; i < h.length; i++)
			h[i]++;
		PrintUtils.printArray(h);
		Integer start = null, end = null;
		System.out.println(maxArea(h));
	}

}
