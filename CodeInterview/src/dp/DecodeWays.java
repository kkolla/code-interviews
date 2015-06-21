package dp;

import utils.CreateUtils;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * 
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 *
 */
public class DecodeWays {
	
	// nums[i]: number of ways to decode s.substring(0, i)
	// init: nums[0] = 1, num[1] = 1
	// nums[i] = 
	//		nums[i - 2] if s.charAt(i - 1) == 0
	// 		nums[i - 1] + nums[i - 2] if
	//			(1) s.charAt(i - 2) != 0
	//			(2) Integer.parseInt(s.substring(i - 2, i)) must be less than or equal to 26
	// return: nums[s.length()]
	
	public static int numDecodings(String s) {	
        if (s == null || s.isEmpty() || s.charAt(0) == '0')
        	return 0;
        	
        int[] nums = new int[s.length() + 1];
        nums[0] = 1; // consider there's 1 way to decode an empty string (for building the array up)
        nums[1] = 1; // because the first character is not 0, there's 1 way to decode a single character

        for (int i = 2; i <= s.length(); i++) {
        	// if the second last character is not 0 and the last two characters are less than 27
        	// we can divide the string by s.substring(0, s.length() - 2) and s.substring(s.length() - 2)
        	if (s.charAt(i - 2) != '0' && Integer.parseInt(s.substring(i - 2, i)) <= 26) {
        		nums[i] += nums[i - 2];
        	}
        	
        	// if the last character is not 0, we can divide the string by s.substring(0, s.length() - 1) and s.charAt(s.length() - 1)
        	if (s.charAt(i - 1) != '0') {
        		nums[i] += nums[i - 1];
        	}
        }
        
		return nums[s.length()];
    }

	public static void main(String[] args) {
		String s = String.valueOf(CreateUtils.randNonNegInt(1000));
		System.out.println(s);
		System.out.println(numDecodings(s));
	}

}
