package string;

/**
 * Validate if a given string is numeric.
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. 
 * You should gather all requirements up front before implementing one.
 *
 */
public class ValidNumber {
	public boolean isNumber(String s) {
        if (s == null || s.isEmpty()) return false;
        boolean seenNumber = false, seenDecimalPoint = false, seenE = false, seenNumberAfterE = false;
        
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') i++;
        
        while (i < s.length() && s.charAt(i) != ' ') {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                if (seenNumber || seenDecimalPoint || seenE) return false;
                if (c == '+') {
                    if (i + 1 < s.length()) {
                        if (s.charAt(i + 1) == '+') return false;
                        else if (s.charAt(i + 1) == '-') i++;
                    }
                } else {
                    if (i + 1 < s.length()) {
                        if (s.charAt(i + 1) == '-') return false;
                        else if (s.charAt(i + 1) == '+') i++;
                    }
                }
            } else if (c >= '0' && c <= '9') {
                seenNumber = true;
                if (seenE) seenNumberAfterE = true;
            } else if (c == '.') {
                if (seenDecimalPoint || seenE) return false;
                seenDecimalPoint = true;
            } else if (c == 'e' || c == 'E') {
                if (!seenNumber || seenE) return false;
                seenE = true;
                if (i + 1 < s.length() && (s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-')) i++;
            } else {
                return false;
            }
            i++;
        }
        
        while (i < s.length()) {
            if (s.charAt(i) != ' ') return false;
            i++;
        }
        
        return seenNumber && (!seenE || seenNumberAfterE);
    }
}
