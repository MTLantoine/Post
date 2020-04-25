package post.letter;

import static org.junit.Assert.*;

import org.junit.*;

public class UrgentLetterTest extends LetterTest {

	public Letter<?> createLetter() {
		return new UrgentLetter(new RegisteredLetter(new UrgentLetter(new SimpleLetter(super.sender, super.receiver, null))));
	}
	
	public Letter<?> createMockLetter() {
		return new MockLetter(super.sender, super.receiver, null);
	}
	
	@Test
	public void getCostTest() {
		assertEquals(2.3f, super.letter.getCost(), 0);
	}
	
	@Test
	public void toStringTest() {
		assertEquals("Lettre simple URGENT en recommendé URGENT", super.letter.toString());
	}

}
