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

	public static boolean isPalindromeByComparingEnds(int x) {
		if (x < 0) return false;
        
        int divisor = 1;
        while (x / divisor >= 10) divisor *= 10;
        
        while (x > 0) {
        	System.out.println("x = " + x + ", divisor = " + divisor + ", left = " + x / divisor + ", right = " + x % 10);
            if (x / divisor != x % 10) return false;
            x = (x % divisor) / 10;
            divisor /= 100;
        }
        return true;
	}

	public static void main(String[] args) {
		/*for (int i = 0; i <= 99999; i++)
			if (isPalindromeByComparingEnds(i))
				System.out.println(i);*/
		System.out.println(isPalindromeByComparingEnds(1000021));
	}

}
