package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 * Note:
 * You may assume both s and t have the same length.
 *
 */
public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapL2R = new HashMap<Character, Character>();
        Map<Character, Character> mapR2L = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i), ct = t.charAt(i);
            Character c = mapL2R.get(cs);
            if (c != null && c != ct) {
                return false;
            } else {
                mapL2R.put(cs, ct);
            }
            c = mapR2L.get(ct);
            if (c != null && c != cs) {
                return false;
            } else {
                mapR2L.put(ct, cs);
            }
        }
        return true;
    }
}
