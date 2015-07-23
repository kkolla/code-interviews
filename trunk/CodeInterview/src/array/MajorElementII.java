package array;

import java.util.ArrayList;
import java.util.List;

public class MajorElementII {
	public List<Integer> majorityElement(int[] nums) {
        // there're at most 2 majority elements
        int major1 = 0, major2 = 0; // assuming nums doesn't contain non-negative numbers
        int count1 = 0, count2 = 0;
        for (int num : nums) {
            if (major1 == num) {
                count1++;
            } else if (major2 == num) {
                count2++;
            } else if (count1 == 0) {
                major1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                major2 = num;
                count2 = 1;
            } else {
                // count1 and count2 are not 0, major1 and major2 are not num
                count1--;
                count2--;
            }
        }
        
        List<Integer> result = new ArrayList<Integer>();
        count1 = 0;
        count2 = 0;
        for (int num : nums)
            if (num == major1) count1++;
            else if (num == major2) count2++;
        if (count1 > nums.length / 3) result.add(major1);
        if (count2 > nums.length / 3) result.add(major2);
        return result;
    }
}
