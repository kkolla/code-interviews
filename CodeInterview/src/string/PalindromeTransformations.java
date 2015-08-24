package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import utils.PrintUtils;

/**
 * company: Uber, stage: phone
 * 
 * http://www.mitbbs.com/article_t/JobHunting/32873313.html
 * 
 * 1. 给定一个string，判断能否用这个string来组成一个palindrome。e.g. 'uber' -->
 * False, 'aab' --> True, 'carecra' --> True
 * 
 * 2. Follow up: 给出所有能够组成的palindrome，因为时间原因可以不用担心
 * duplicates。
 *
 */
public class PalindromeTransformations {
	
	public static boolean canTransformToPalindrome(String s) {
		Map<Character, Integer> charToCount = countCharacters(s);
		
		boolean hasOddCountChar = false;
		for (int count : charToCount.values()) {
			if (count % 2 != 0) {
				if (hasOddCountChar) return false;
				hasOddCountChar = true;
			}
		}
		
		return true;
	}
	
	private static Map<Character, Integer> countCharacters(String s) {
		Map<Character, Integer> charToCount = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int count = 1 + (charToCount.containsKey(c) ? charToCount.get(c) : 0);
			charToCount.put(c, count);
		}
		return charToCount;
	}
	
	public static List<String> transformPalindromes(String s) {
		List<String> palindromes = new ArrayList<String>();
		if (!canTransformToPalindrome(s)) return palindromes;
		
		Map<Character, Integer> charToCount = countCharacters(s);
		Character oddCountChar = null;
		for (Entry<Character, Integer> entry : charToCount.entrySet()) {
			if (entry.getValue() % 2 != 0) {
				oddCountChar = entry.getKey();
				charToCount.put(entry.getKey(), entry.getValue() - 1);
				break;
			}
		}
		
		if (oddCountChar != null) charToCount.remove(oddCountChar);
		String temp = oddCountChar == null ? "" : oddCountChar.toString();	
		transformPalindromes(charToCount, temp, palindromes, charToCount.size());
		
		return palindromes;
	}

	private static void transformPalindromes(
		Map<Character, Integer> charToCount, String temp, List<String> palindromes, int remainingDistinctChars) {
		if (remainingDistinctChars == 0) {
			palindromes.add(temp);
		} else {
			for (Entry<Character, Integer> entry : charToCount.entrySet()) {
				char c = entry.getKey();
				int count = entry.getValue();
				if (count == 0) continue;
				
				charToCount.put(c, count - 2);
				if (count - 2 == 0) remainingDistinctChars--;
				
				transformPalindromes(charToCount, c + temp + c, palindromes, remainingDistinctChars);
				
				charToCount.put(c, count);
				if (count - 2 == 0) remainingDistinctChars++;
			}
		}
		
	}

	public static void main(String[] args) {
		String[] ss = {"bbaa", "aab", "uber", "carecra"};
		for (String s : ss) {
			System.out.println(s + ": " + canTransformToPalindrome(s));
			PrintUtils.printList(transformPalindromes(s));
		}
	}

}
