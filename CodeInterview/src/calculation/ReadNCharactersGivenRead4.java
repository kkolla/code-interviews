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
	
	int bufSize = 0;
	int offset = 0;
	int totalRead = 0;
	char[] buf4 = new char[4];
	
	public int read(char[] buf, int n) throws Exception {

		boolean eof = false;
				
		while(!eof && totalRead < n) {
			if (bufSize == 0) {
				bufSize = read4(buf4);
				if (bufSize < 4) eof = true;
			}
			
			int bytesToRead = Math.min(totalRead, bufSize);
			System.arraycopy(buf4, offset, buf, totalRead, bytesToRead);
			
			offset = (offset + bytesToRead) % 4;
			bufSize -= bytesToRead;
			totalRead += bytesToRead;
		}
		
		return totalRead;
	}

	private int read4(char[] buf4) throws Exception {
		throw new Exception("fake impl");
	}
}
