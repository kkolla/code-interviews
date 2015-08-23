package calculation;

public class UglyNumberII {
	public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int i = 0, j = 0, k = 0;
        int p = 1;
        while (p < n) {
        	int min = Math.min(Math.min(nums[i] * 2, nums[j] * 3), nums[k] * 5);
        	nums[p] = min;
        	if (min == nums[i] * 2) i++;
        	if (min == nums[j] * 3) j++;
        	if (min == nums[k] * 5) k++;
        	p++;
        }
        
        return nums[n - 1];
    }
}
