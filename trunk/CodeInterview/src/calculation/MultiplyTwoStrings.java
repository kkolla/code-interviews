package calculation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class MultiplyTwoStrings {
	
	public static String multiply(String num1, String num2) {
		boolean positive = true;
		if (num1.charAt(0) == '-') {
			num1 = num1.substring(1);
			positive = !positive;
		}
		if (num2.charAt(0) == '-') {
			num2 = num2.substring(1);
			positive = !positive;
		}
		
		num1 = new StringBuilder(num1).reverse().toString();
		num2 = new StringBuilder(num2).reverse().toString();
		
		// num1 * num2 has at most n + m digits
		int[] d = new int[num1.length() + num2.length()];
		
		for (int i = 0; i < num1.length(); i++) {
			int d1 = num1.charAt(i) - '0';
			for (int j = 0; j < num2.length(); j++) {
				int d2 = num2.charAt(j) - '0';
				int product = d1 * d2;
				d[i + j] += product;
			}
		}
		
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < d.length; i++) {
			d[i] += carry;
			carry = d[i] / 10;
			d[i] = d[i] % 10;
			sb.insert(0, d[i]);
		}

		int nonZeroStart = 0;
		while (nonZeroStart < sb.length() && sb.charAt(nonZeroStart) == '0') 
			nonZeroStart++;
		String s = sb.substring(nonZeroStart);
		
		return s.isEmpty() ? "0" : (positive ? s : "-" + s);
	}
	

	public static String multiply2(String a, String b) throws Exception {
		if (a == null || b == null || a.length() == 0 || b.length() == 0)
			return null;
		boolean positive = true;
		if (a.charAt(0) == '-') {
			a = a.substring(1);
			positive = !positive;
		}
		if (b.charAt(0) == '-') {
			b = b.substring(1);
			positive = !positive;
		}
		if (a.charAt(0) == '0' || b.charAt(0) == '0')
			return "0";
		List<Integer> r = new ArrayList<Integer>();
		int carry = 0;
		for (int ai = a.length() - 1, offset = 0; ai >= 0; ai--, offset++) {
			carry = 0;
			for (int bi = b.length() - 1; bi >= 0; bi--) {
				char sc = a.charAt(ai);
				char lc = b.charAt(bi);
				int product = (sc - '0') * (lc - '0');
				int index = b.length() - 1 - bi + offset;
				if (index < r.size()) {
					int old = r.get(index);
					r.set(index, (carry + old + product) % 10);
					carry = (carry + old + product) / 10;
				} else {
					r.add((carry + product) % 10);
					carry = (carry + product) / 10;
				}
			}
			if (carry > 0) {
				r.add(carry);
			}
		}

		StringBuffer sb = new StringBuffer();
		if (!positive)
			sb.append('-');
		for (int i = r.size() - 1; i >= 0; i--)
			sb.append(r.get(i));
		return sb.toString();
	}

	public static void main(String[] args) throws Exception {
		System.out.println(multiply("123", "44444") + " "
				+ new BigInteger("123").multiply(new BigInteger("44444")));
		System.out.println(multiply("-869", "-34") + " "
				+ new BigInteger("-869").multiply(new BigInteger("-34")));
		System.out.println(multiply("234897234897", "43498")
				+ " "
				+ new BigInteger("234897234897").multiply(new BigInteger(
						"43498")));
		System.out.println(multiply("4897234803249871203760934750",
				"-546907242072304878123")
				+ " "
				+ new BigInteger("4897234803249871203760934750")
						.multiply(new BigInteger("-546907242072304878123")));
		System.out
				.println(multiply("59823473710", "24628946293461231023634576")
						+ " "
						+ new BigInteger("59823473710")
								.multiply(new BigInteger(
										"24628946293461231023634576")));
		
		System.out.println(multiply2("123", "-456"));
	}

}
