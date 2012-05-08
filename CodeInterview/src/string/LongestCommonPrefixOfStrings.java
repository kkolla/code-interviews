package string;

public class LongestCommonPrefixOfStrings {

	public static String prefix(String[] ss) {
		if (ss.length == 0)
			return "";
		StringBuffer sb = new StringBuffer("");
		boolean done = false;
		int t = 0;
		while (!done) {
			char c = '!';
			for (int i = 0; i < ss.length; i++) {
				if (ss[i] == null || t == ss[i].length()) {
					done = true;
					break;
				}
				if (i == 0)
					c = ss[i].charAt(t);
				else if (ss[i].charAt(t) != c) {
					done = true;
					break;
				}
			}
			if (!done) {
				sb.append(c);
				t++;
			}
		}
		return sb.toString();
	}
}
