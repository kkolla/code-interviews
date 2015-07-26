package recursion;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
	public List<String> restoreIpAddresses(String s) {
        return restoreIpAddresses(s, 0, 0, "", new ArrayList<String>());    
    }
    
    private List<String> restoreIpAddresses(String s, int start, int numParts, String ip, List<String> result) {
        if (numParts == 4 || start == s.length()) {
            if (numParts == 4 && start == s.length()) {
                result.add(ip);
            }
        } else {
            for (int i = start; i < s.length() && i - start + 1 <= 3; i++) { // i - start + 1 <= 3 to avoid NumberFormatException
                int num = Integer.parseInt(s.substring(start, i + 1));
                if (num <= 255) {
                    restoreIpAddresses(s, i + 1, numParts + 1, ip.isEmpty() ? num + "" : ip + "." + num, result);
                }
                if (num == 0) break; // to avoid parsing "0..."
            }
        }
        return result;
    }
}
