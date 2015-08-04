package string;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 *
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char a = s.charAt(i);
            char b = s.charAt(j);
            a = (char) (a >= 'A' && a <= 'Z' ? a - ('A' - 'a') : a);
            b = (char) (b >= 'A' && b <= 'Z' ? b - ('A' - 'a') : b);
            if (a != b) return false;
            i++;
            j--;
        }
        return true;
    }
}
