package string;

public class SearchFirstStringAppearance {

	// O(nm)
	public static int strstr(String haystack, String needle) {
		if (haystack == null || needle == null)
			return -1;
		if (needle.length() == 0)
			return 0;
		for (int i = 0; i < haystack.length(); i++)
			for (int j = 0; j < needle.length() && (i + j) < haystack.length(); j++)
				if (needle.charAt(j) != haystack.charAt(i + j))
					break;
				else if (j == needle.length() - 1)
					return i;

		return -1;
	}

	public static int strstr(String[] haystacks, String needle) {
		if (haystacks == null || haystacks.length == 0 || needle == null)
			return -1;
		if (needle.length() == 0)
			return 0;

		int count = 0;
		int finished = 0;
		int i = 0;
		while (finished < haystacks.length) {
			for (int j = 0; j < needle.length(); j++, i++) {
				if (i == haystacks[finished].length()) {
					i = 0;
					count += haystacks[finished].length();
					finished++;
					if (finished == haystacks.length)
						break;
				}
				char c = haystacks[finished].charAt(i);
				if (needle.charAt(j) != c)
					break;
				else if (j == needle.length() - 1)
					return count + i - j;
			}
			i++;
		}

		return -1;
	}

	// O(n+m) for KMP

	public static void main(String[] args) {
		String[] haystacks = { "a", "bbbbbc", "c" };
		String needle = "cc";
		System.out.println(strstr(haystacks, needle));
	}

}
