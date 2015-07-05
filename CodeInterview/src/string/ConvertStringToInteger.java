package string;

/*
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary until 
 * the first non-whitespace character is found. Then, starting from this character, 
 * takes an optional initial plus or minus sign followed by as many numerical digits as possible, 
 * and interprets them as a numerical value.
 * The string can contain additional characters after those that form the integral number, 
 * which are ignored and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid integral number, 
 * or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * If no valid conversion could be performed, a zero value is returned. 
 * If the correct value is out of the range of representable values, 
 * INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 * 
 input	output	expected	
 ""	0	0	
 "1"	1	1	
 "+1"	1	1	
 "-1"	-1	-1	
 "123"	123	123	
 "-123"	-12-123
 "010"	10	10	
 "+00131204"	131204	131204	
 "-01324000"	-1324000	-1324000	
 "2147483647"	2147483647	2147483647	
 "-2147483647"	-2147483647	-2147483647	
 "-2147483648"	-2147483648	-2147483648	
 "2147483648"	2147483647	2147483647	
 "-2147483649"	-2147483648	-2147483648	
 "abc"	0	0	
 "-abc"	0	0	
 "1a"	1	1	
 "23a8f"	23	23	
 "-3924x8fc"	-3924	-3924	
 "   321"	321	321	
 "   -321"	-321	-321	
 "123  456"	123	123	
 "123   "	123	123	
 "   - 321"	0	0	
 "   +4488"	4488	4488	
 "  +  413"	0	0	
 " ++c"	0	0	
 " ++1"	0	0	
 " --2"	0	0	
 "  -2"	-2	-2
 */
public class ConvertStringToInteger {
	public static boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}

	public int atoi(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int i = 0;
		while (s.charAt(i) == ' ')
			i++;
		if (i == s.length())
			return 0;
		boolean positive = true;
		if (s.charAt(i) != '+' && s.charAt(i) != '-' && !isDigit(s.charAt(i)))
			return 0;
		else if (s.charAt(i) == '+')
			i++;
		else if (s.charAt(i) == '-') {
			positive = false;
			i++;
		}
		int num = 0;
		while (i < s.length()) {
			char c = s.charAt(i);
			if (!isDigit(s.charAt(i))) {
				return positive ? num : -num;
			}
			int digit = c - '0';
			if (positive && (double) (Integer.MAX_VALUE - digit) / 10 <= num)
				return Integer.MAX_VALUE;
			if (!positive && (double) (Integer.MIN_VALUE + digit) / 10 >= -num)
				return Integer.MIN_VALUE;
			num = num * 10 + digit;
			i++;
		}
		return positive ? num : -num;
	}
	
	
	public static int myAtoi(String str) {
        if (str == null || str.isEmpty()) return 0;
        
        int p = 0;
        while (p < str.length()) {
        	char c = str.charAt(p);
        	if (c == ' ') p++;
        	else break;
        }
        
        boolean positive = true;
        if (str.charAt(p) == '+' || str.charAt(p) == '-') {
        	if (str.charAt(p) == '-') positive = false;
        	p++;
        }
        
        long result = 0;
        while (p < str.length()) {
        	char c = str.charAt(p);
        	if (isDigit(c)) result = result * 10 + (c - '0');
        	else break;
        	if (positive && result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        	else if (!positive && -result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        	p++;
        }
        
        return (int) (positive ? result : -result);
    }
	
	public static void main(String[] s) {
		System.out.println(myAtoi("+00131204"));
	}
}
