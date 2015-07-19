package array;

/**
 * Given an unsorted array, find the maximum difference 
 * between the successive elements in its sorted form.
 * Try to solve it in linear time/space.
 * Return 0 if the array contains less than 2 elements.
 * You may assume all elements in the array are non-negative 
 * integers and fit in the 32-bit signed integer range.
 *
 */
public class MaximumGap {
	// O(numBuckets) = O((range / (range / numNumbers)) = O(n)
	public static int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        
        int min = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
        	min = Math.min(min, nums[i]);
        	max = Math.max(max, nums[i]);
        }
		
		// create buckets to distribute the numbers 
        // each bucket saves the smallest and greatest value in the bucket
        int bucketInterval = (max - min) / nums.length + 1;
        int numBuckets = (max - min) / bucketInterval + 1;
        int[][] buckets = new int[numBuckets][2];
        for (int i = 0; i < buckets.length; i++)
        	buckets[i] = new int[] { -1, -1 }; // -1 means no element
        
        for (int num : nums) {
        	int i = (num - min) / bucketInterval;
        	buckets[i][0] = buckets[i][0] == -1 ? num : Math.min(num, buckets[i][0]);
        	buckets[i][1] = buckets[i][1] == -1 ? num : Math.max(num, buckets[i][1]);
        }
        
        // the answer is equal to the smallest-greatest difference in the adjacent buckets
        int maxInPrevBucket = buckets[0][1]; // first bucket is guaranteed to have num in it
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < buckets.length; i++) {
        	if (buckets[i][0] == -1) continue;
        	result = Math.max(result, buckets[i][0] - maxInPrevBucket);
        	maxInPrevBucket = buckets[i][1];
        }
        
        return result;
    }

	public static void main(String[] args) {
		int[] nums = {1, 10, 5, 7};
		System.out.println(maximumGap(nums));
	}

}
