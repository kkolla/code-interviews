package string;

// copied but not studied!
// http://www.blackwasp.co.uk/NumberToRoman.aspx
// mapping I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000
public class ConvertIntegerToRomanNumber {
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
			System.out.println(i + " => " + toRoman(i));
		}
	}

}
