package string;

/*
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 */
public class CountAndSay {

	public static String coundAndSay(int n) {
		String s = "1";
		for (int i = 1; i < n; i++) {
			String t = "";
			int count = 1;
			char c = s.charAt(0);
			for (int j = 1; j < s.length(); j++) {
				if (s.charAt(j) == c) {
					count++;
				} else {
					t += String.valueOf(count) + String.valueOf(c);
					count = 1;
					c = s.charAt(j);
				}
			}
			t += String.valueOf(count) + String.valueOf(c);
			s = t;
		}
		return s;
	}

	public static void main(String[] args) {
		for (int i = 1; i < 20; i++) {
			System.out.println(coundAndSay(i));
		}
	}

}
