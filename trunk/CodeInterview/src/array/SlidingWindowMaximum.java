package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
	// O(n)
	public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (nums.length == 0) return result;
        
        // the first head of the deque always contains the largest
        Deque<Integer> dq = new LinkedList<Integer>();

        // put k numbers into the dequeue
        for (int i = 0; i < k; i++) {
            // if the number is greater than or equal to the last of the queue
            // we can safely remove them as they won't be the largest
            // this is the key to make the algorithm linear
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) dq.pollLast();
            // enqueue the current number to the last
            // note we enqueue the index so we can determine if this element is out of window
            dq.offer(i);
        }
        
        for (int i = k; i < nums.length; i++) {
            // collect the maxmimun number in the previous window
            result.add(nums[dq.peekFirst()]);
            // add the current number and maintain the constraint
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) dq.pollLast();
            // dequeue the fist head if it is out of window
            if (!dq.isEmpty() && dq.peekFirst() < i - k + 1) dq.pollFirst();
            dq.offer(i);
        }
        // the last maxmimun hasn't been collected yet
        result.add(nums[dq.pollFirst()]);

        return result;
    }
    
    // O(nlog(k))
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        int[] result = new int[nums.length - k + 1];
        
        for (int i = 0; i < nums.length; i++) {
        	pq.offer(nums[i]);
        	int j = i - k + 1;
            if (j >= 0) {
                int max = pq.peek();
                result[j] = max;
                int prev = nums[j];
                pq.remove(prev);
            }
        }
        
        return result;
    }
}
