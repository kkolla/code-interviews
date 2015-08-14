package calculation;

import utils.CreateUtils;

/*
 * Divide two integers without using multiplication, division and mod operator.
 */
public class DivideTwoIntegers {

	// O(quotient)?
	// doesn't work for dividend = Integer.MIN_VALUE
	public static int divideByMinus(int dividend, int divisor, int q) {
		if (dividend < 0 && divisor < 0)
			return divideByMinus(-dividend, -divisor, q);
		else if (dividend < 0)
			return -divideByMinus(-dividend, divisor, q);
		else if (divisor < 0)
			return -divideByMinus(dividend, -divisor, q);

		if (dividend < divisor)
			return q;
		if (divisor == 1) // optimization?
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
	public static int divideByBitOps(int dividend, int divisor) {
		if (divisor == 0) return Integer.MAX_VALUE;
		
		long dvd = dividend < 0 ? -dividend : dividend;
		long dvs = divisor < 0 ? -divisor : divisor;
		boolean negative = (dividend < 0) ^ (divisor < 0);
		
		int shifts = 0;
		while ((dvs << shifts) <= dvd) {
			shifts++;
		}
		
		int quotient = 0;
		while (dvd >= dvs) {
			long product = dvs << shifts;
			if (product <= dvd) {
				quotient += 1 << shifts;
				dvd -= product;
			}
			shifts--;
		}
		return negative ? -quotient : quotient;
	}
	
	// passes leetcode
	public static int divide(int dividend, int divisor) {
		long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
 
        long res = 0;
        while(dvd >= dvs) {
            int shifts = 0;
            while (dvd >= (dvs << shifts)) {
            	shifts++;
            }
            dvd -= dvs << (shifts - 1);
            res += (long) 1 << (shifts - 1);
        }

        if ((divisor < 0) ^ (dividend < 0)) res = -res;
        
        return (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) ? Integer.MAX_VALUE : (int) res;
	}

	// best solution?
	// http://basicalgos.blogspot.com/2012/03/5-divide-two-integers.html

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 100000; i++) {
			int dividend = CreateUtils.randInt(100);
			int divisor = CreateUtils.randInt(100);
			System.out.print(dividend + "/" + divisor + "=");
			// System.out.println(divideByBitOps(dividend, divisor));
			System.out.println(divide(dividend, divisor));
		}
	}

}
