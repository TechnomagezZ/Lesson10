package exercises;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PalindromeTest {
	
	Palindrome testPalindrome = new Palindrome();
	String word = "";

	@Test
	void testLoadWords() {
		assertTrue(testPalindrome.loadWords().contains("apple"));
	}
	
	// 2. Test that a word exists in the dictionary 
	@Test
	void testWordExists() throws Exception {
		assertTrue(testPalindrome.wordExsits().contains("orange"));
	}
	
	// 3. Test that a word is a palindrome
	@Test
	void testIsPalindrome() throws Exception {
		assertTrue(testPalindrome.isPalindrome("Abba"));
		assertFalse(testPalindrome.isPalindrome("Milk"));
	}
}
