package calculation;

import utils.CreateUtils;

/*
 * Divide two integers without using multiplication, division and mod operator.
 */
public class DivideTwoIntegers {

	// O(quotient)?
	public static int divideByMinus(int dividend, int divisor, int q) {
		if (dividend < 0 && divisor < 0)
			return divideByMinus(-dividend, -divisor, q);
		else if (dividend < 0)
			return -divideByMinus(-dividend, divisor, q);
		else if (divisor < 0)
			return -divideByMinus(dividend, -divisor, q);

		if (dividend < divisor)
			return q;
		if (divisor == 1)
			return dividend;
		return divideByMinus(dividend - divisor, divisor, ++q);
	}

	// O(log(dividend)), used multiplication
	// does not work for Integer.MIN_VALUE if saving into int
	public static int divideByBinarySearch(int dividend2, int divisor2) {
		long dividend = dividend2, divisor = divisor2;
		boolean positive = true;
		if (dividend < 0) {
			positive = !positive;
			dividend = -dividend;
		}
		if (divisor < 0) {
			positive = !positive;
			divisor = -divisor;
		}
		// quotient ranges from 0 to dividend
		long low = 0, high = dividend;
		while (low <= high) {
			long q = low + ((high - low) >> 1);
			long remainder = dividend - q * divisor;
			if (remainder >= 0 && remainder < divisor)
				return positive ? (int) q : (int) -q;
			else if (remainder >= divisor)
				low = q + 1;
			else
				high = q - 1;
		}
		// should never reach here
		return Integer.MAX_VALUE;
	}

	// O(32c)
	public static int divideByBitOps(int dividend2, int divisor2)
			throws Exception {
		if (divisor2 == 0)
			throw new Exception("divided by zero");
		long dividend = dividend2, divisor = divisor2;
		boolean positive = true;
		if (dividend < 0) {
			positive = !positive;
			dividend = -dividend;
		}
		if (divisor < 0) {
			positive = !positive;
			divisor = -divisor;
		}
		int shifts = 0;
		while ((divisor << shifts) <= dividend) {
			shifts++;
		}
		int q = 0;
		while (dividend >= divisor) {
			long product = divisor << shifts;
			if (product <= dividend) {
				q |= 1 << shifts;
				dividend -= product;
			}
			shifts--;
		}
		return positive ? q : -q;
	}

	// best solution?
	// http://basicalgos.blogspot.com/2012/03/5-divide-two-integers.html

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 100000; i++) {
			int dividend = CreateUtils.randInt(100);
			int divisor = CreateUtils.randInt(100);
			System.out.print(dividend + "/" + divisor + "=");
			System.out.println(divideByBitOps(dividend, divisor));
		}
	}

}
