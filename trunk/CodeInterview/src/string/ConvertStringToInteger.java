package string;

/*
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
	public boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}

	public int atoi(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int i = 0;
		while (s.charAt(i) == ' ')
			i++;
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
}
