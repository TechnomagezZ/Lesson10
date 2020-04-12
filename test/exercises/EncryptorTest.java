package exercises;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EncryptorTest {
	String input = "";
	String[] sentence = new String[6];

	@Test
	void testEncryptOneCharacter() {
		assertEquals("c", Encryptor.encrypt("a"));
	}

	@Test
	void testEncryptWord() throws Exception {
		assertEquals("ccc", Encryptor.encrypt("aaa"));
		assertEquals("Lcxc", Encryptor.encrypt("Java"));
	}
	
	// Exercise: decrypt this sentence: Nkxg"nqpi"cpf"rtqurgt#
	
	@Test
	void testDecryptWord() throws Exception {
		
		String input = "Nkxg nqpi cpf rtqurgt#";
		
		
		assertEquals("aaa", Encryptor.decrypt("ccc"));
		assertEquals("Java", Encryptor.decrypt("Lcxc"));
		
		
		Encryptor.decrypt(input);
			
			System.out.print(Encryptor.decrypt(input).toString());
			
	}
	
	public static void main(String args[]) {
		
		
	}
	
}
