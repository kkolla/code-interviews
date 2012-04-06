package string;

public class StringReplacement {

	public static boolean isMatchFromBegining(String s, String pattern) {
		if (s.length() < pattern.length())
			return false;
		return s.substring(0, pattern.length()).equals(pattern);
	}

	public static String replace(String s, String pattern) {
		int slow = 0, fast = 0;
		while (fast < s.length()) {
			boolean isMatch = false;
			while (isMatchFromBegining(s.substring(fast), pattern)) {
				isMatch = true;
				fast += pattern.length();
			}
			if (isMatch) {
				s = s.substring(0, slow) + 'X' + s.substring(slow + 1);
				slow++;
			}
			if (fast < s.length()) {
				s = s.substring(0, slow) + s.charAt(fast)
						+ s.substring(slow + 1);
				slow++;
				fast++;
			}
		}
		return s.substring(0, slow);
	}

	public static void main(String[] args) {
		System.out.println(replace("aabaaaaaabaab", "aaa"));
	}
}
