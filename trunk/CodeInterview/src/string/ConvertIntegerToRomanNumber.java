package string;

// copied but not studied!
// http://www.blackwasp.co.uk/NumberToRoman.aspx
// mapping I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000

// A number written in Arabic numerals can be broken into digits. For example, 1903 is composed of 1 (one thousand), 9 (nine hundreds), 0 (zero tens), and 3 (three units). To write the Roman numeral, each of the non-zero digits should be treated separately. In the above example, 1,000 = M, 900 = CM, and 3 = III. Therefore, 1903 = MCMIII.[4]
// The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more. (They may appear more than three times if they appear non-sequentially, such as XXXIX.) "D", "L", and "V" can never be repeated.[5][6]
// "I" can be subtracted from "V" and "X" only. "X" can be subtracted from "L" and "C" only. "C" can be subtracted from "D" and "M" only. "V", "L", and "D" can never be subtracted[6]
// Only one small-value symbol may be subtracted from any large-value symbol.
public class ConvertIntegerToRomanNumber {
	
	public static String intToRoman(int num) {
		String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String s = "";
        for (int i = 0; i < symbols.length; i++) {
        	while (num >= values[i]) {
        		s += symbols[i];
        		num -= values[i];
        	}
        }
        return s;
    }
	
	public static String repeat(char c, int times) {
		String s = "";
		for (int i = 0; i < times; i++)
			s += c;
		return s;
	}

	public static String toRoman(int n) {
		if (n < 4)
			return repeat('i', n);
		if (n < 6)
			return repeat('i', 5 - n) + "v";
		if (n < 9)
			return "v" + repeat('i', n - 5);
		if (n < 11)
			return repeat('i', 10 - n) + "x";
		if (n < 40)
			return repeat('x', n / 10) + toRoman(n % 10);
		if (n < 60)
			return repeat('x', 5 - n / 10) + 'l' + toRoman(n % 10);
		if (n < 90)
			return "l" + repeat('x', n / 10 - 5) + toRoman(n % 10);
		if (n < 110)
			return repeat('x', 10 - n / 10) + "c" + toRoman(n % 10);
		if (n < 400)
			return repeat('c', n / 100) + toRoman(n % 100);
		if (n < 600)
			return repeat('c', 5 - n / 100) + 'd' + toRoman(n % 100);
		if (n < 900)
			return "d" + repeat('c', n / 100 - 5) + toRoman(n % 100);
		if (n < 1100)
			return repeat('c', 10 - n / 100) + "m" + toRoman(n % 100);
		if (n < 4000)
			return repeat('m', n / 1000) + toRoman(n % 1000);
		return "?";
	}

	public static void main(String[] args) {
		for (int i = 1; i < 4000; i++) {
			System.out.println(i + " => " + toRoman(i) + " or " + intToRoman(i));
		}
	}

}
