package bitops;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, 
 * return the bitwise AND of all numbers in this range, inclusive.
 * For example, given the range [5, 7], you should return 4.
 *
 */
public class BitwiseANDOfNumbersRange {
	
	// http://www.cnblogs.com/grandyang/p/4431646.html
	public int rangeBitwiseAnd(int m, int n) {
		int shifts = 0;
		while (m != n) {
			m >>= 1;
			n >>= 1;
			shifts++;
		}
		return m << shifts;
    }

	public int naive(int m, int n) {
        int result = m;
        for (int i = m + 1; i <= n; i++)    
            result &= i;
        return result;
    }
}
