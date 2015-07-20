package dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import utils.CreateUtils;
import utils.PrintUtils;


public class LargestRectangleInHistogram {
	
    // O(n^2)
    public int largestRectangleAreaNaive(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            // pruning: if the next bar's height is bigger, no need to compute in the current run
            if (i + 1 < height.length && height[i] <= height[i + 1]) continue;
            int minHeight = height[i];
            for (int j = i; j >= 0; j--) {
                minHeight = Math.min(minHeight, height[j]);
                int width = i - j + 1;
                maxArea = Math.max(maxArea, minHeight * width);
            }
        } 
        return maxArea;
    }
    
    // O(n)
    // http://fisherlei.blogspot.com/2012/12/leetcode-largest-rectangle-in-histogram.html
    public int largestRectangleArea(int[] height) {
        Stack<Integer> s = new Stack<Integer>(); // for saving indicies of an ascending histograms
        int maxArea = 0, i = 0;
        while (!(i == height.length && s.isEmpty())) {
            if (i < height.length && (s.isEmpty() || height[i] > height[s.peek()])) {
                s.push(i);
                i++;
            } else {
                while (!s.isEmpty() && (i == height.length || height[i] <= height[s.peek()])) {
                    int t = s.pop();
                    int width = s.isEmpty() ? i : i - 1 - s.peek();
                    maxArea = Math.max(maxArea, width * height[t]);
                }  
            }
        }
        return maxArea;
    }

    // http://tech-queries.blogspot.com/2011/03/maximum-area-rectangle-in-histogram.html
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
			while (!s.isEmpty() && h[s.peek()] >= h[i])
				s.pop();
			int leftOffset = s.isEmpty() ? i : i - s.peek() - 1;
			widths[i] += leftOffset;
			left.put(i, i - leftOffset);
			s.push(i);
		}
		s = new Stack<Integer>();
		for (int i = h.length - 1; i >= 0; i--) {
			while (!s.isEmpty() && h[s.peek()] >= h[i])
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
		int[] h = CreateUtils.randNonNegIntArray(10, 10);
		for (int i = 0; i < h.length; i++)
			h[i]++;
		PrintUtils.printArray(h);
		Integer start = null, end = null;
		System.out.println(maxArea(h));
	}

}
