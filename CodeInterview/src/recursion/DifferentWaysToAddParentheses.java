package recursion;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                for (int left : diffWaysToCompute(input.substring(0, i)))
                    for (int right: diffWaysToCompute(input.substring(i + 1))) {
                        int num = 0;
                        switch (input.charAt(i)) {
                            case '+': num = left + right; break;
                            case '-': num = left - right; break;
                            case '*': num = left * right; break;
                        }
                        result.add(num);
                    }
            }
        }
        if (result.isEmpty()) result.add(Integer.parseInt(input));
        
        return result;
    }
}
