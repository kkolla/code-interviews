package string;

/*
 * Validate if a given string is numeric.
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. 
 * You should gather all requirements up front before implementing one.
 */
public class CheckIfStringIsValidNumber {

	public static boolean isValid(String s) {
		if (s == null || s.length() == 0)
			return false;
		int pos = 0;
		while (pos < s.length() && s.charAt(pos) == ' ')
			pos++;
		if (pos == s.length())
			return false;
		if (!Character.isDigit(s.charAt(pos)) && s.charAt(pos) != '+'
				&& s.charAt(pos) != '-')
			return false;
		boolean plus = s.charAt(pos) == '+';
		boolean minus = s.charAt(pos) == '-';
		if (plus || minus) {
			pos++;
			if (pos == s.length())
				return false;
			else if (s.charAt(pos) == '-' && minus || s.charAt(pos) == '+'
					&& plus)
				return false;
			else if (s.charAt(pos) == '-' || s.charAt(pos) == '+') {
				pos++;
				if (pos == s.length())
					return false;
			}
		}
		boolean decimal = false, scientific = false;
		boolean digit = false;
		while (pos < s.length()) {
			char c = s.charAt(pos);
			if (c == ' ')
				break;
			else if (c == 'e' || c == 'E')
				if (!digit || scientific)
					return false;
				else
					scientific = true;
			else if (c == '.')
				if (decimal)
					return false;
				else
					decimal = true;
			else if (Character.isDigit(c))
				digit = true;
			else
				return false;
			pos++;
		}
		while (pos < s.length()) {
			if (s.charAt(pos) == ' ')
				pos++;
			else
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String[] ss = { "0", " 0.1 ", "abc", "1 a", "2e10", "+1", "-1", "++1",
				"--1", "+-1", "-+1", "+-", "1..1", "12345", "12345.678  ",
				"123E456E" };
		for (String s : ss)
			System.out.println(s + ": " + isValid(s));
	}

}
