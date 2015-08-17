package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given an array of n integer, and a moving window(size k), 
 * move the window at each iteration from the start of the array, 
 * find the median of the element inside the window at each moving.
 * (If there are even numbers in the array, return the N/2-th number 
 * after sorting the element in the window. )
 * 
 * Example
 * For array [1,2,7,8,5], moving window size k = 3. return [2,7,7]
 * At first the window is at the start of the array like this
 * [ | 1,2,7 | ,8,5] , return the median 2;
 * then the window move one step forward.
 * [1, | 2,7,8 | ,5], return the median 7;
 * then the window move one step forward again.
 * [1,2, | 7,8,5 | ], return the median 7;
 */
public class SlidingWindowMedian {
	
	// O(nlog(n)), assuming the modified PriorityQueue supports O(log(n)) removal
	public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (nums.length == 0 || k == 0) return result;

        // for numbers <= median
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        // for numbers > median
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);

        for (int i = 0; i < nums.length; i++) {
        	int num = nums[i];
        	if (maxHeap.isEmpty() || num < maxHeap.peek()) {
        		maxHeap.add(num);
        	} else {
        		minHeap.add(num);
        	}
        	adjustHeaps(maxHeap, minHeap);
        	
        	if (i - k + 1 >= 0) {
        		assert(maxHeap.size() + minHeap.size() == k);
        		result.add(maxHeap.peek());
        		int numToRemove = nums[i - k + 1];
        		// regular heap doesn't support O(log(n)) random removal
        		if (numToRemove <= maxHeap.peek()) maxHeap.remove(numToRemove);
        		else minHeap.remove(numToRemove);
        		adjustHeaps(maxHeap, minHeap);
        	}
        }
        
        return result;
    }

	private void adjustHeaps(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
		assert(Math.abs(maxHeap.size() - minHeap.size()) <= 1);
		
		// keep the 0 <= maxHeap.size() - minHeap.size() <= 1
        // so the median is always maxHeap.peek();
		if (maxHeap.size() - minHeap.size() > 1) {
			minHeap.add(maxHeap.poll());
		} else if (minHeap.size() - maxHeap.size() > 0) {
			maxHeap.add(minHeap.poll());
		}
	}
}
