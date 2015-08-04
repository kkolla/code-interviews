package calculation;

/**
 * The API: int read4(char *buf) reads 4 characters at a time from a file. 
 * The return value is the actual number of characters read. 
 * For example, it returns 3 if there is only 3 characters left in the file. 
 * By using the read4 API, implement the function int read(char *buf, int n) 
 * that reads n characters from the file. 
 * Note:
 * The read function will only be called once for each test case. 
 *
 */
public class ReadNCharactersGivenRead4 {
	
	public int read(char[] buf, int n) throws Exception {
		int count = 0;
		
		char[] buf4 = new char[4];
		while(count < n) {
			int charsRead = read4(buf4);
			int i = 0;
			for (; i < Math.min(charsRead, n - count); i++) {
				buf[count + i] = buf4[i];
			}
			count += i;
			if (charsRead < 4) break;
		}
		
		return count;
	}

	private int read4(char[] buf4) throws Exception {
		throw new Exception("fake impl");
	}
}
