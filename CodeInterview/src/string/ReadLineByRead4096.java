package string;

public class ReadLineByRead4096 {

	public static class Reader4096 {
		int position;
		String content;

		public Reader4096(String content) {
			this.position = 0;
			this.content = content;
		}

		public char[] read4096() {
			final int block = 12; // use 12 to simulate 4096
			if (position + block < content.length()) {
				char[] cs = content.substring(position, position + block)
						.toCharArray();
				position += block;
				return cs;
			} else if (position < content.length()) {
				char[] cs = content.substring(position, content.length())
						.toCharArray();
				position += block;
				return cs;
			} else {
				return null;
			}
		}
	}

	public static class ReaderLine {
		Reader4096 reader;
		char[] cs;
		int position;

		public ReaderLine(String content) {
			reader = new Reader4096(content);
			cs = null;
			position = 0;
		}

		public char[] readByLine() {
			StringBuffer sb = new StringBuffer("");
			FW: while (true) {
				if (cs == null) {
					cs = reader.read4096();
					if (cs == null)
						return null;
				}
				while (position < cs.length) {
					if (cs[position] == '\n' || cs[position] == '\0') {
						position++;
						break FW;
					}
					sb.append(cs[position++]);
				}

				// position == cs.length
				cs = null;
				position = 0;

			}
			return sb.toString().toCharArray();
		}
	}

	public static void main(String[] args) {
		String content = "Shuffle Duration counter records the period of shuffling.\nIn general, the shuffle duration for each task is computed by the time that one shuffle finishes minus the time that its corresponding reducer starts.\nThe former time is given by the last successful shuffle response, while the latter records the time right before map output fetching.\nThus, we can set the counter just one time by keeping the largest shuffle duration for each reduce task, once all shuffle responses are received.\nThe counter is useful as we compute the standard variation of all the duration in the above test,\nto determine whether the entire shuffling process is balanced.\n";
		ReaderLine reader = new ReaderLine(content);
		char[] line = null;
		while ((line = reader.readByLine()) != null) {
			System.out.println(new String(line));
		}
	}

}
