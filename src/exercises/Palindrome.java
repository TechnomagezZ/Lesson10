package exercises;

import java.util.List;



import examples.FileHelper;

public class Palindrome {
	
	public List<String> loadWords() {
		return FileHelper.loadFileContentsIntoArrayList("resource/words.txt");
	}

	public List<String> wordExsits() {
		return FileHelper.loadFileContentsIntoArrayList("resource/words.txt");
	}
	
	public boolean isPalindrome(String word) {
		String reverse = new StringBuffer(word).reverse().toString();
		boolean palindrome;
		if(word.equalsIgnoreCase(reverse)) {
			palindrome = true;
		}
		else {
			palindrome = false;
		}
		return palindrome;
	}
	
	
}
