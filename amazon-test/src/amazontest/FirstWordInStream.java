package amazontest;

import java.util.ArrayList;
import java.util.List;

/*
Find the first word in a stream which is not repeated in the rest of the stream.
Please note that you are being provided a stream as a source for the characters.
The stream is guaranteed to eventually terminate (i.e. return false from a call to the hasNext() method), though it could be very long.
You will access this stream through the provided interface methods.
A call to hasNext() will return whether the stream contains any more characters to process.
A call to next() will return the next character to be processed in the stream.
It is not possible to restart the stream. 

You can write any methods or classes you would like. However, all new classes must be written in this 
file and you cannot change the FirstWordInStream class name, the Stream interface contract or the firstWord() method signature.

Example: 
--------
	Input: "The angry dog was red. And the cat was also angry."
	Output: "dog"
In this example, the word "dog" is the first word in the stream which is not repeated in the rest of the stream. 

	
*/
public class FirstWordInStream {

	public interface Stream {
		char next();

		boolean hasNext();
	}

	public static class StreamImpl implements Stream {

		private String text;
		
		private int characterIndex;
		
		public StreamImpl(String text) {
			this.text = text;
		}

		@Override
		public char next() {
			return text.charAt(characterIndex++);
		}

		@Override
		public boolean hasNext() {
			return characterIndex < text.length();
		}

	}

	public String firstWord(final Stream input) {
		List<String> words = putWordsOnList(input);
		
		boolean wordWasFound = false; 
		
		for (int wordToBeSearchIndex = 0; wordToBeSearchIndex < words.size(); wordToBeSearchIndex++) {
			for (int nextStringIndex = wordToBeSearchIndex + 1; nextStringIndex < words.size(); nextStringIndex++) {
				
				if (words.get(wordToBeSearchIndex).equalsIgnoreCase(words.get(nextStringIndex))) {
					wordWasFound = true;
					break;
				} else {
					wordWasFound = false;
				}
				
			}
			if (!wordWasFound) {
				return words.get(wordToBeSearchIndex);
			}
		}
		
		return "All words are repeated.";
	}

	private List<String> putWordsOnList(final Stream input) {
		List<String> words = new ArrayList<>();
		
		String word = "";
		
		while(input.hasNext()) {
			char character = input.next();
			
			if (character != ' ' && character != '.') {
				word += character;
				
				continue;
			}
			
			words.add(word);
			
			word = "";
		}
		return words;
	}

	public static void main(String[] args) {
		String input = "The angry dog was red. And the cat was also.";

		Stream stream = new StreamImpl(input);
		
		System.out.println(new FirstWordInStream().firstWord(stream));
	}
}
