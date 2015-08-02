package calculation;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * For example,
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 *
 */
public class FractionToRecurringDecimal {

	public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        
        String result = "";
        if (numerator < 0 ^ denominator < 0) result += "-";
        
        long numeratorLong = numerator, denominatorLong = denominator;
        numeratorLong = Math.abs(numeratorLong);
        denominatorLong = Math.abs(denominatorLong);
        result += String.valueOf(numeratorLong / denominatorLong);
        
        long remainder = numeratorLong % denominatorLong;
        if (remainder == 0) return result;
        else result += ".";

        Map<Long, Integer> remainderToResultIndex = new HashMap<Long, Integer>();
        while (remainder != 0) {
        	if (remainderToResultIndex.containsKey(remainder)) {
        		int prevIndex = remainderToResultIndex.get(remainder);
        		result = result.substring(0, prevIndex) + "(" + result.substring(prevIndex) + ")";
        		break;
        	}
        	
        	System.out.println("putting remainder " + remainder + " index " + result.length() + " to map");
        	remainderToResultIndex.put(remainder, result.length());
        	
        	remainder *= 10;
        	result += String.valueOf(remainder / denominatorLong);
        	
        	remainder %= denominatorLong;
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		System.out.println(3d / 7);
		System.out.println(fractionToDecimal(3, 70));
	}

}
