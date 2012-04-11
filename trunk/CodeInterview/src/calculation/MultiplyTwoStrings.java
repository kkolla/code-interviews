package calculation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class MultiplyTwoStrings {

	public static String multiply(String a, String b) throws Exception {
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
	}

}
