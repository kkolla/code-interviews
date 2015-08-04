package string;

/**
 * Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 *
 */
public class ReverseWordsInAString {
	public String reverseWords(String s) {
        int end = s.length() - 1;
        String r = "";
        while (end >= 0) {
            while (end >= 0 && s.charAt(end) == ' ') end--;
            if (end == -1) break;
            int start = end;
            while (start >= 0 && s.charAt(start) != ' ') start--;
            String word = s.substring(start + 1, end + 1);
            r = r.isEmpty() ? word : r + " " + word;
            end = start;
        }
        return r;
    }
}
