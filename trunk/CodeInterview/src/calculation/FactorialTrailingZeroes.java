package calculation;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 *
 */
public class FactorialTrailingZeroes {
	
	// trailing 0's = # of (2, 5) prime factors of n = # of 5 prime factors of n
	// = n / 5 + n / 25 + n / 125 + ...
	public static int trailingZeroes(int n) {
		int c = 0;
		for (long i = 5; i <= n; i *= 5)
			c += n / i;
		return c;
    }

	public static void main(String[] args) {
		System.out.println(trailingZeroes(25));
	}

}
