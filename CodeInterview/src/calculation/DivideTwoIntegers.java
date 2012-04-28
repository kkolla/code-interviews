package calculation;

import utils.CreateUtils;

/*
 * Divide two integers without using multiplication, division and mod operator.
 */
public class DivideTwoIntegers {

	// O(quotient)?
	public static int divide(int dividend, int divisor, int q) {
		if (dividend < 0 && divisor < 0)
			return divide(-dividend, -divisor, q);
		else if (dividend < 0)
			return -divide(-dividend, divisor, q);
		else if (divisor < 0)
			return -divide(dividend, -divisor, q);

		if (dividend < divisor)
			return q;
		if (divisor == 1)
			return dividend;
		return divide(dividend - divisor, divisor, ++q);
	}

	// O(log(dividend)), used multiplication
	// does not work for Integer.MIN_VALUE
	public static int divide2(int dividend, int divisor) {
		boolean positive = true;
		if (dividend < 0) {
			positive = !positive;
			dividend = -dividend;
		}
		if (divisor < 0) {
			positive = !positive;
			divisor = -divisor;
		}
		if (dividend < divisor)
			return 0;
		// quotient ranges from 0 to dividend
		int low = 1, high = dividend;
		while (low <= high) {
			int q = low + ((high - low) >> 1);
			int remainder = dividend - q * divisor;
			if (remainder >= 0 && remainder < divisor)
				return positive ? q : -q;
			else if (remainder == divisor)
				return positive ? q + 1 : -(q + 1);
			else if (remainder > divisor)
				low = q + 1;
			else
				high = q - 1;
		}
		// should never reach here
		return Integer.MAX_VALUE;
	}

	// best solution?
	// http://basicalgos.blogspot.com/2012/03/5-divide-two-integers.html

	public static void main(String[] args) {
		for (int i = 0; i < 100000; i++) {
			int dividend = CreateUtils.randInt(100);
			int divisor = CreateUtils.randInt(100);
			System.out.print(dividend + "/" + divisor + "=");
			System.out.println(divide2(dividend, divisor));
		}
	}

}
