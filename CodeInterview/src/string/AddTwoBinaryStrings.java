package string;

import utils.CreateUtils;

/*
 * Given two binary strings, return their sum (also a binary string)
 * e.g. "110"+"11"="1001"
 */
public class AddTwoBinaryStrings {

	public static String add(String a, String b) {
		StringBuilder sb = new StringBuilder("");
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int digitA = i < 0 ? 0 : a.charAt(i) - '0';
            int digitB = j < 0 ? 0 : b.charAt(j) - '0';
            int sum = digitA + digitB + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        
        if (carry > 0) sb.append(1);
        return sb.reverse().toString();
    }

	public static String addRecursive(String a, String b, int i, int j) {
		if (i == a.length() - 1 && j == b.length() - 1) {
			int c1 = a.charAt(i), c2 = b.charAt(j);
			if (c1 == '0' && c2 == '0')
				return "00";
			else if (c1 == '1' && c2 == '1')
				return "10";
			else
				return "01";
		} else if (i == a.length() - 1) {
			return addRecursive(a, b, i, j + 1);
		}
		// tried to implement a recursive version but stopped here..
		return null;
	}

	public static void main(String[] args) {
		String[] numbers = { "11", "1", "0", "1111", "10000", "10010" };
		for (int i = 0; i < 10; i++) {
			String num1 = numbers[CreateUtils.randNonNegInt(numbers.length)];
			String num2 = numbers[CreateUtils.randNonNegInt(numbers.length)];
			System.out.println(num1 + " + " + num2 + " = " + add(num1, num2));
		}
	}

}
