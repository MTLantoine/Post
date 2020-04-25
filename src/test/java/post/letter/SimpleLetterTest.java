package post.letter;

import static org.junit.Assert.*;

import org.junit.*;

import post.content.*;

public class SimpleLetterTest extends LetterTest {

	public Letter<?> createLetter() {
		return new SimpleLetter(super.sender, super.receiver, new ContentText("blablabla"));
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
		assertEquals("Lettre simple", super.letter.toString());
	}

}
