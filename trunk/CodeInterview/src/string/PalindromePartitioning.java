package string;

import java.util.ArrayList;
import java.util.List;

import utils.PrintUtils;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab",
 * Return

 * [
 *    ["aa","b"],
      ["a","a","b"]
 *  ]
 *
 */
public class PalindromePartitioning {
	
	public static List<List<String>> partition(String s) {
		return partition(s, new ArrayList<List<String>>(), new ArrayList<String>());
    }

	private static List<List<String>> partition(String s, List<List<String>> result, List<String> temp) {
		if (s.isEmpty()) {
			if (!temp.isEmpty()) result.add(new ArrayList<String>(temp));
			return result;
		}
		
		for (int i = 0; i < s.length(); i++) {
			String word = s.substring(0, i + 1);
			if (isPalindrome(word)) {
				temp.add(word);
				partition(s.substring(i + 1), result, temp);
				temp.remove(word);
			}
		}
		
		return result;
	}
	
	private static boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) return false;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		for (List<String> l : partition("aab"))
			PrintUtils.printList(l);
	}

}
