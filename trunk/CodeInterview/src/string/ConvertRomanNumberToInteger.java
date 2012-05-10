package string;

public class ConvertRomanNumberToInteger {

	// should be able to be simplified to constant space
	public static int toInt(String roman) throws Exception {
		String chars = "IVXLCDM";
		int[] values = { 1, 5, 10, 50, 100, 500, 1000 };
		int k = values[chars.indexOf(roman.charAt(roman.length() - 1))];
		int prevValue = k;
		for (int i = roman.length() - 2; i >= 0; i--) {
			int j = chars.indexOf(roman.charAt(i));
			int currValue = values[j];
			if (prevValue > currValue)
				k = k - currValue;
			else
				k = k + currValue;
			prevValue = currValue;
		}
		return k;

	}

	public static void main(String[] args) throws Exception {
		String[] romans = { "D", "II", "III", "IV", "VI", "VII", "VIII", "IX",
				"XL", "XLIX" };
		for (String roman : romans)
			System.out.println(roman + " => " + toInt(roman));
	}

}
