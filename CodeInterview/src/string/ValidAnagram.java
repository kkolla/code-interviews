package string;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 */
public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] counts = new int[26];
        for (char c : s.toCharArray()) 
            counts[c - 'a']++;
        for (char c : t.toCharArray()) {
            if (--counts[c - 'a'] < 0) return false;
        }
        return true;
    }
    
    // O(nlogn): sort & compare
}
