package string;

import utils.PrintUtils;

public class ConvertRomanNumberToInteger {

	public static int toInt(String roman) throws Exception {
		char[] rom = roman.toCharArray();
		int[] a = new int[roman.length()];
		for (int i = 0; i < a.length; i++) {
			if (rom[i] == 'I')
				a[i] = 1;
			else if (rom[i] == 'V')
				a[i] = 5;
			else if (rom[i] == 'X')
				a[i] = 10;
			else if (rom[i] == 'L')
				a[i] = 50;
			else if (rom[i] == 'C')
				a[i] = 100;
			else if (rom[i] == 'D')
				a[i] = 500;
			else if (rom[i] == 'M')
				a[i] = 1000;
			else {
				throw new Exception("Invalid Value");
			}
		}
		PrintUtils.printArray(a);
		int k = a[a.length - 1];
		for (int i = a.length - 1; i > 0; i--) {
			if (a[i] > a[i - 1])
				k = k - a[i - 1];
			else if (a[i] == a[i - 1] || a[i] < a[i - 1])
				k = k + a[i - 1];
		}
		return k;

	}

	public static void main(String[] args) throws Exception {
		String[] romans = { "II", "III", "IV", "VI", "VII", "VIII", "IX", "XL",
				"XLIX" };
		for (String roman : romans)
			System.out.println(roman + " => " + toInt(roman));
	}

}
