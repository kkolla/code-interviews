package recursion;

import utils.CreateUtils;

/*
 * Given two binary strings, return their sum (also a binary string)
 */
public class AddTwoBinaryStrings {

	public static String add(String a, String b) {
		if (a == null || b == null)
			return null;
		int i = a.length() - 1, j = b.length() - 1;
		int carry = 0;
		StringBuffer sb = new StringBuffer("");
		while (i >= 0 && j >= 0) {
			int add1 = a.charAt(i) - '0';
			int add2 = b.charAt(j) - '0';
			int sum = add1 + add2 + carry;
			int digit = sum % 2;
			carry = sum / 2;
			sb.append(digit);
			i--;
			j--;
		}
		String c = i >= 0 ? a : b;
		int k = i >= 0 ? i : j;
		while (k >= 0) {
			int add1 = c.charAt(k) - '0';
			int add2 = 0;
			int sum = add1 + add2 + carry;
			int digit = sum % 2;
			carry = sum / 2;
			sb.append(digit);
			k--;
		}
		if (carry == 1)
			sb.append(1);
		return reverse(sb.toString());
	}

	public static String reverse(String s) {
		char[] cs = s.toCharArray();
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			char c = cs[i];
			cs[i] = cs[j];
			cs[j] = c;
		}
		return new String(cs);
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
