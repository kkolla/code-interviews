package string;

/*
 �.� Matches any single character.
 �*� Matches zero or more of the preceding element.
 The matching should cover the entire input string (not partial).

 Some examples:
 isMatch("aa","a")  false
 isMatch("aa","aa")  true
 isMatch("aaa","aa")  false
 isMatch("aa", "a*")  true
 isMatch("aa", ".*")  true
 isMatch("ab", ".*")  true
 isMatch("aab", "c*a*b")  true
 */
public class RegularExpressionMatching {

	// TLE
	public boolean isMatch2(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        if (s.isEmpty()) 
            return p.length() > 1 && p.charAt(1) == '*' && isMatch2(s, p.substring(2));
        
        if (p.length() > 1 && p.charAt(1) == '*') {
            if (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)) 
                return isMatch2(s.substring(1), p) || isMatch2(s.substring(1), p.substring(2))
                    || isMatch2(s, p.substring(2)); 
            else
                return isMatch2(s, p.substring(2)); 
        } else {
            return (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))
                && isMatch2(s.substring(1), p.substring(1));
        }
    }
	
	public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        if (p.length() > 1 && p.charAt(1) == '*') {
        	int i = -1; // for the empty s case
        	while(i < s.length() && (i < 0 || s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
        		if (isMatch(s.substring(i + 1), p.substring(2)))	
        			return true;
        		i++;
        	}
        	return false;
        } else {
        	// p.length() == 1 or p.charAt(1) != '*'
        	if (s.isEmpty() || (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.'))
        		return false;
        	// the first characters match, check the rest
        	return isMatch(s.substring(1), p.substring(1));
        }
    }

	public static void main(String[] args) {
		String[] ss = { "aaaa", "a", "aa", "aa", "aa", "ab", "ab", "aab", "ab", "ab" };
		String[] ps = { "a*", "b", "a", "b*a", ".*", "ab*", "abc*", "c*a*b",
				".*", ".*c" };
		for (int i = 0; i < ss.length; i++)
			System.out.println(ss[i] + ", " + ps[i] + ": "
					+ isMatch(ss[i], ps[i]));
	}

}
