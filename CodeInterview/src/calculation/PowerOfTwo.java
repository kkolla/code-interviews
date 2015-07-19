package calculation;

/**
 * Given an integer, write a function to determine if it is a power of two.
 *
 */
public class PowerOfTwo {
	// http://articles.leetcode.com/2010/09/fun-with-bit-operations.html
	public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }
}
