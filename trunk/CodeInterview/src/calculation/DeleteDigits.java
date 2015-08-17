package calculation;

public class DeleteDigits {
	// http://ec2-107-21-18-224.compute-1.amazonaws.com/article_t/JobHunting/32880939.html
    public static String deleteDigits(String A, int k) {
        StringBuilder sb = new StringBuilder(A);
        for (int i = 0; i < sb.length() - 1 && k > 0;) {
            if (i >= 0 && sb.charAt(i) > sb.charAt(i + 1)) {
                // why we should always delete A.charAt(i)?
                sb.deleteCharAt(i);
                k--;
                i--; // the deletion of i may affect i - 1
            } else {
                i++;
            }
        }
        
        // sb is in ascending order now, so we just need to delete the tail
        while (k > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }
        
        while (sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        
        return sb.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(deleteDigits("1708042", 3));
	}

}
