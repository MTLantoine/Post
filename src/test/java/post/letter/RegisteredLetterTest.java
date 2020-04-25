package post.letter;

import static org.junit.Assert.*;

import org.junit.*;

public class RegisteredLetterTest extends LetterTest {

	public Letter<?> createLetter() {
		return new RegisteredLetter(new SimpleLetter(super.sender, super.receiver, null));
	}
	
	public Letter<?> createMockLetter() {
		return new MockLetter(super.sender, super.receiver, null);
	}
	
	@Test
	public void getCostTest() {
		assertEquals(0.575f, super.letter.getCost(), 0);
	}
	
	@Test
	public void toStringTest() {
		assertEquals("Lettre simple en recommendé", super.letter.toString());
	}

}
