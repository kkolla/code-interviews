package array;

import java.util.Arrays;

/*
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {
	// time: O(n), space: O(1)
    public int majorityElement2(int[] nums) {
        int count = 1, major = nums[0];
        for (int i = 1; i < nums.length; i++)
            if (count == 0) {
                major = nums[i];
                count = 1;
            } else {
                count += nums[i] == major ? 1 : -1;
            }
        return major;
    }
    
    // time: O(32n), space: O(1)
    // We would need 32 iterations, each calculating the number of 1's for the ith bit of all n numbers. Since a majority must exist, therefore, either count of 1's > count of 0's or vice versa (but can never be equal). The majority number’s ith bit must be the one bit that has the greater count.
    public int majorityElement(int[] nums) {
        int major = 0;
        for (int i = 0, mask = 1; i < 32; i++, mask <<= 1) {
            int bitCount = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & mask) != 0) bitCount++;
                if (bitCount > nums.length / 2) {
                    major |= mask;
                    break;
                }
            }
        }
        return major;
    }
    
    // time: O(nlog(n)), space: O(1)
    public int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
