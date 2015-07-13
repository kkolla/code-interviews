package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers, 
 * find the length of the longest consecutive elements sequence.

 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

 * Your algorithm should run in O(n) complexity.
 *
 */
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<Integer>();
        for (int num : nums)
            s.add(num);
        int maxLen = 0;
        for (int num : nums) {
            int count = 1;
            
            int left = num - 1;
            while (s.contains(left)) {
                count++;
                s.remove(left);
                left--;
            }
            
            int right = num + 1;
            while (s.contains(right)) {
                count++;
                s.remove(right);
                right++;
            }
            
            maxLen = Math.max(count, maxLen);
        }
        return maxLen;
    }
}
