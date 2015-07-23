package array;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
	// O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        
        Deque<Integer> dq = new LinkedList<Integer>();
        int[] result = new int[nums.length - k + 1];
        
        for (int i = 0; i < k; i++) {
        	while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()])
        		dq.pollLast();
        	dq.offer(i);
        }
        
        for (int i = k; i < nums.length; i++) {
        	result[i - k] = nums[dq.peekFirst()];
        	while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()])
        		dq.pollLast();
        	while (!dq.isEmpty() && dq.peekFirst() <= i - k)
        		dq.pollFirst();
        	dq.offer(i);
        }
        result[nums.length - k] = nums[dq.pollFirst()];
        
        return result;
    }
    
    // O(nlog(k))
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
			public int compare(Integer a, Integer b) {
                return b.compareTo(a);
            }   
        });
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
