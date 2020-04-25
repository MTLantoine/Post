package post.letter;

import static org.junit.Assert.*;

import org.junit.*;

public class ThanksLetterTest extends LetterTest {

	public Letter<?> createLetter() {
		return new ThanksLetter(super.sender, super.receiver);
	}
	
	public Letter<?> createMockLetter() {
		return new MockLetter(super.sender, super.receiver, null);
	}
	
	@Test
	public void getCostTest() {
		assertEquals(0.5f, super.letter.getCost(), 0);
	}
	
	@Test
	public void toStringTest() {
		assertEquals("Lettre simple de remerciement", super.letter.toString());
	}

}
