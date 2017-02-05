
public class PercentTwenties {
	public PercentTwenties() {
		
	}
	public char[] addPTwenties (char[] input) {
		int editorEnd = input.length-1;
		int readerEnd = editorEnd;
		while (readerEnd >= 0) {
			if (input[readerEnd] != ' ') {
				while(readerEnd >= 0 && input[readerEnd] != ' ') {
					input[editorEnd] = input[readerEnd];
					editorEnd--;
					readerEnd--;
				}
				if (readerEnd >= 2) {
					input[editorEnd] = '0';
					editorEnd--;
					input[editorEnd] = '2';
					editorEnd--;
					input[editorEnd] = '%';
					editorEnd--;
				}
			} else {
				readerEnd--;
			}
			
		}
		return input;
	}
}
