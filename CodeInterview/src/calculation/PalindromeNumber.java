package calculation;

/*
 * Determine whether an integer is a palindrome. 
 * Do this without extra space.
 */
public class PalindromeNumber {

	// potential overflow
	public static boolean isPalindromeByReversingNumber(int n) {
		if (n < 0)
			return false;
		int m = 0;
		int t = n;
		while (t > 0) {
			m = m * 10 + t % 10;
			t /= 10;
		}
		return m == n;
	}

	public static boolean isPalindromeByComparingEnds(int n) {
		if (n < 0)
			return false;
		int divisor = 1;
		int t = n;
		while (t >= 10) { // pitfall: >
			t /= 10;
			divisor *= 10;
		}
		t = n;
		while (t >= 10) {
			int left = t / divisor;
			int right = t % 10;
			if (left != right)
				return false;
			t = (t / 10) % (divisor / 10);
			divisor /= 100;
		}
		return true;
	}

	public static void main(String[] args) {
		for (int i = 0; i <= 99999; i++)
			if (isPalindromeByComparingEnds(i))
				System.out.println(i);
	}

}
