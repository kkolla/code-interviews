package array;

public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;

        int sum = 0, start = 0, end = 0, minLen = -1;
        while (end < nums.length) {
            // if the current sum is less than s, keep adding elements
            while (sum < s && end < nums.length) {
                sum += nums[end];
                end++;
            }
        
            // if the current sum is greater than or equal to s, try to increase start to get a smaller subarray
            while (sum >= s && start < nums.length) {
                int len = end - start;
                minLen = minLen == -1 ? len : Math.min(minLen, len);
                sum -= nums[start];
                start++;
            }
        }
        return minLen == -1 ? 0 : minLen;
    }
}
